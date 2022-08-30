package Generate_Pdf.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
@Service
public class PdfFileServiceClass {
	public void pdfCreation() {
		String dest = "C:\\Users\\admin\\Desktop\\office\\sample.pdf";
		try {
			PdfWriter writer = new PdfWriter(dest);
			PdfDocument pdf = new PdfDocument(writer);
			pdf.addNewPage();

			Document document = new Document(pdf);
			document.close();
			System.out.println("PDF Created");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
