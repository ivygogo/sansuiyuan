package tw.edu.ntut.sce.java18.htmlToPdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pdf.do")
public class HtmlToPDF extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
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
    HtmlToPDF testHtmlToPDF = new HtmlToPDF();
    try {
      ConverterProperties converterProperties = new ConverterProperties();

      // 設定字型
      FontProvider fontProvider = new FontProvider();
      fontProvider.addFont(
          "/Users/afra/Desktop/_SpringBoot/workspace/sansuiyuan/wuli/src/main/webapp/fonts/MSJH.TTC");
      fontProvider.addStandardPdfFonts();
      fontProvider.addSystemFonts(); // for fallback
      converterProperties.setFontProvider(fontProvider);

      testHtmlToPDF.createPdf(
          "/Users/afra/Desktop/_SpringBoot/workspace/sansuiyuan/wuli/src/main/webapp/rent/contractPdfUse.html",
          "/Users/afra/Desktop/_SpringBoot/workspace/sansuiyuan/wuli/src/main/webapp/rent/contract.pdf",
          converterProperties);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // src 是要轉的html路徑+名稱,dest是轉出來的pdf路徑名稱,converterProperties是所需要的字型
  public void createPdf(String src, String dest, ConverterProperties converterProperties)
      throws IOException {
    HtmlConverter.convertToPdf(new File(src), new File(dest), converterProperties);
  }
}
