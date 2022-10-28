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
    String body = request.getReader().lines().collect(Collectors.joining());
    System.out.println("START PDF");
    Type type = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> map = new Gson().fromJson(body, type);
    System.out.println("PDFName:" + map.get("pdfName"));
    HtmlToPDFServlet testHtmlToPDF = new HtmlToPDFServlet();
    try {
      ConverterProperties converterProperties = new ConverterProperties();

      // 設定字型
      FontProvider fontProvider = new FontProvider();
      fontProvider.addFont(request.getServletContext().getRealPath("fonts/") + "MSJH.TTC");
      fontProvider.addStandardPdfFonts();
      fontProvider.addSystemFonts(); // for fallback
      converterProperties.setFontProvider(fontProvider);

      Calendar cal = Calendar.getInstance();
      cal.setTime(new java.util.Date());
      var year = cal.get(Calendar.YEAR) - 1911;
      var month = cal.get(Calendar.MONTH) + 1;
      var day = cal.get(Calendar.DAY_OF_MONTH);
      String today = year + " 年 " + month + " 月 " + day + " 日 ";
      // System.out.println(today);
      var pdfString =
          FileUtils.readFileToString(
                  new File(
                      // "/Users/afra/Desktop/_SpringBoot/workspace/sansuiyuan/wuli/src/main/webapp/rent/contractPdfUse.html"
                      request.getServletContext().getRealPath("rent/") + "contractPdfUse.html"))
              .replaceAll("INPUT_RENTER", map.get("renter"))
              .replaceAll("START_YYYY", map.get("startYYY"))
              .replaceAll("START_MM", map.get("startMM"))
              .replaceAll("START_DD", map.get("startDD"))
              .replaceAll("END_YYYY", map.get("endYYY"))
              .replaceAll("END_MM", map.get("endMM"))
              .replaceAll("END_DD", map.get("endDD"))
              .replace("RENT_FEE", map.get("rent"))
              .replace("DEPOSIT_FEE", map.get("deposit"))
              .replaceAll("RENTER_ID", map.get("ID"))
              .replace("RENTER_PHONE", map.get("phone"))
              .replace("RENTER_ADDRESS", map.get("address"))
              .replaceAll("INPUT_GUARNTOR", map.get("guarntor"))
              .replaceAll("GUARNTOR_ID", map.get("guarntorID"))
              .replaceAll("GUARNTOR_PHONE", map.get("guarntorPhone"))
              .replaceAll("GUARNTOR_ADDRESS", map.get("guarntorAddress"))
              .replace("RENTER_SIGN", map.get("renterSign"))
              .replace("GUARANTOR_SIGN", map.get("guarantorSign"))
              .replace("CONFIRM_SIGN", map.get("confirmSign"))
              .replaceAll("TODAY", today);

      testHtmlToPDF.createPdf(
          pdfString,
          request.getServletContext().getRealPath("rent/") + map.get("pdfName") + ".pdf",
          converterProperties,
          map.get("ID"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // src 是要轉的html路徑+名稱,dest是轉出來的pdf路徑名稱,converterProperties是所需要的字型
  public void createPdf(String src, String dest, ConverterProperties converterProperties, String id)
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
