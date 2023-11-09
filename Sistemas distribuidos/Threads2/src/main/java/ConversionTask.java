
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

class ConversionTask extends Thread{

    private final File inputFile;
    private final File outputDirectory;

    public ConversionTask(File inputFile, File outputDirectory) {
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
    }

    @Override
    public void run() {
        try {
            String inputFileName = inputFile.getName();
            String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + ".pdf";
            File outputFile = new File(outputDirectory, outputFileName);

            if (inputFileName.endsWith(".docx")) {
                // Convert .docx to PDF
                XWPFDocument document = new XWPFDocument(new FileInputStream(inputFile));
                PdfOptions options = PdfOptions.create();
                FileOutputStream pdfOutputStream = new FileOutputStream(outputFile);
                PdfConverter.getInstance().convert(document, pdfOutputStream, options);
                pdfOutputStream.close();
            } else if (inputFileName.endsWith(".pptx")) {
                // Convert .pptx to PDF
                XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(inputFile));
                FileOutputStream pdfOutputStream = new FileOutputStream(outputFile);
                ppt.write(pdfOutputStream);
                pdfOutputStream.close();
            } else if (inputFileName.endsWith(".png")) {
                // Convert .png to PDF
                BufferedImage image = ImageIO.read(inputFile);
                PDDocument pdfDocument = new PDDocument();
                PDPage page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
                pdfDocument.addPage(page);
                FileOutputStream pdfOutputStream = new FileOutputStream(outputFile);
                ImageIO.write(image, "png", pdfOutputStream);
                pdfDocument.save(pdfOutputStream);
                pdfDocument.close();
                pdfOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
