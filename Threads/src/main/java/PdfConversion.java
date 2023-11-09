
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.jsoup.Jsoup;

public class PdfConversion implements Runnable {

    private final ChromeOptions options;
    private final String[] urls;

    public PdfConversion(ChromeOptions options, String[] urls) {
        this.options = options;
        this.urls = urls.clone(); // Hacer una copia del arreglo
    }

    @Override
    public void run() {
        WebDriver driver = new ChromeDriver(options);

        for (String url : urls) {
            try {
                driver.get(url);
                String htmlContent = driver.getPageSource();

                // Generar un nombre de archivo único utilizando el sufijo de tiempo en nanosegundos
                String pdfFileName = url.substring(url.lastIndexOf('/') + 1) + "_" + System.nanoTime() + ".pdf";

                createPdf(pdfFileName, htmlContent);

                System.out.println("Convertido: " + url + " -> " + pdfFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }

    private void createPdf(String fileName, String htmlContent) throws Exception {
        try ( OutputStream outputStream = new FileOutputStream(fileName)) {
            // Crear un archivo PDF simple con el contenido HTML
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Agregar el contenido HTML al documento PDF
            String plainTextContent = Jsoup.parse(htmlContent).text(); // Convertir HTML a texto
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph(plainTextContent)); // Agregar el texto al párrafo
            document.add(paragraph);

            document.close();
        }
    }
}
