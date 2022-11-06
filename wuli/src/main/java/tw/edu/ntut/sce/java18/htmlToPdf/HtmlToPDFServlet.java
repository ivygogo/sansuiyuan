package tw.edu.ntut.sce.java18.htmlToPdf;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.font.FontProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

@WebServlet("/pdf.do")
public class HtmlToPDFServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private static final ConverterProperties DEFAULT_CONVERTER_PROPERTIES = new ConverterProperties();

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 設定字型
    FontProvider fontProvider = new FontProvider();
    fontProvider.addFont(config.getServletContext().getRealPath("fonts/") + "MSJH.TTC");
    fontProvider.addStandardPdfFonts();
    fontProvider.addSystemFonts(); // for fallback
    DEFAULT_CONVERTER_PROPERTIES.setFontProvider(fontProvider);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //  processRequest(request, response);
    var target = request.getParameter("target");
    var targetPdf = request.getServletContext().getRealPath("rent/" + target);
    response.setContentType("application/pdf");
    var inputStream = new FileInputStream(targetPdf);
    var outputStream = response.getOutputStream();
    IOUtils.copy(inputStream, outputStream);
    outputStream.flush();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    System.out.println("START PDF");
    Map<String, String> requestBody = parseRequestBody(request);
    String pdfName = getPdfName(requestBody);
    System.out.println("PDFName:" + pdfName);
    try {
      String pdfContent = preparePdfContent(request, requestBody);

      createPdf(
          pdfContent,
          request.getServletContext().getRealPath("rent/") + pdfName + ".pdf",
          DEFAULT_CONVERTER_PROPERTIES,
          requestBody.get("ID"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Map<String, String> parseRequestBody(HttpServletRequest request) throws IOException {
    Type type = new TypeToken<Map<String, String>>() {}.getType();
    String body = request.getReader().lines().collect(Collectors.joining());
    return new Gson().fromJson(body, type);
  }

  private String getPdfName(Map<String, String> requestBody) {
    return requestBody.get("startYYY")
        + requestBody.get("roomBuilding")
        + requestBody.get("roomPosition")
        + requestBody.get("roomFloor")
        + requestBody.get("roomType");
  }

  private String preparePdfContent(HttpServletRequest request, Map<String, String> requestBody)
      throws IOException {
    return FileUtils.readFileToString(
            new File(
                request.getServletContext().getRealPath("rent/") + "contractPdfUse.html"))
        .replaceAll("INPUT_RENTER", requestBody.get("renter"))
        .replaceAll("START_YYYY", requestBody.get("startYYY"))
        .replaceAll("START_MM", requestBody.get("startMM"))
        .replaceAll("START_DD", requestBody.get("startDD"))
        .replaceAll("END_YYYY", requestBody.get("endYYY"))
        .replaceAll("END_MM", requestBody.get("endMM"))
        .replaceAll("END_DD", requestBody.get("endDD"))
        .replace("RENT_FEE", requestBody.get("rent"))
        .replace("DEPOSIT_FEE", requestBody.get("deposit"))
        .replaceAll("RENTER_ID", requestBody.get("ID"))
        .replace("RENTER_PHONE", requestBody.get("phone"))
        .replace("RENTER_ADDRESS", requestBody.get("address"))
        .replaceAll("INPUT_GUARNTOR", requestBody.get("guarntor"))
        .replaceAll("GUARNTOR_ID", requestBody.get("guarntorID"))
        .replaceAll("GUARNTOR_PHONE", requestBody.get("guarntorPhone"))
        .replaceAll("GUARNTOR_ADDRESS", requestBody.get("guarntorAddress"))
        .replace("RENTER_SIGN", requestBody.get("renterSign"))
        .replace("GUARANTOR_SIGN", requestBody.get("guarantorSign"))
        .replace("CONFIRM_SIGN", requestBody.get("confirmSign"))
        .replaceAll("TODAY", getTodayLiteral());
  }

  private String getTodayLiteral() {
    Calendar cal = Calendar.getInstance();
    var year = cal.get(Calendar.YEAR) - 1911;
    var month = cal.get(Calendar.MONTH) + 1;
    var day = cal.get(Calendar.DAY_OF_MONTH);
    return year + " 年 " + month + " 月 " + day + " 日 ";
  }

  // src 是要轉的html路徑+名稱,dest是轉出來的pdf路徑名稱,converterProperties是所需要的字型
  private void createPdf(
      String src, String dest, ConverterProperties converterProperties, String id)
      throws IOException {
    WriterProperties props =
        new WriterProperties()
            .setStandardEncryption(
                id.getBytes(),
                null,
                EncryptionConstants.ALLOW_PRINTING,
                EncryptionConstants.ENCRYPTION_AES_128);
    PdfWriter writer = new PdfWriter(new FileOutputStream(dest), props);
    HtmlConverter.convertToPdf(src, writer, converterProperties);
  }
}
