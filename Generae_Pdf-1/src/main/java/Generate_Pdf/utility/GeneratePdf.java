package Generate_Pdf.utility;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {

	private static final String FILE_NAME = "D:\\spring tools codes here\\Generae_Pdf-1\\pdfdocs\\sample4.pdf";

	public void writeUsingIText() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

			// open
			document.open();

			Paragraph p = new Paragraph();
			p.add("Ticket");
			p.setAlignment(Element.ALIGN_CENTER);

			document.add(p);

			Paragraph p2 = new Paragraph();
			p2.add("Your ticket is booked successfully."); // no alignment

			document.add(p2);

			Font f = new Font();
			f.setStyle(Font.BOLD);
			f.setSize(8);

			document.add(new Paragraph("Check details here.", f));
			addEmptyLine(document, 1);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			// Creating a table
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Jitendra"));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Java"));
			PdfPCell cell6 = new PdfPCell(new Paragraph("Learn"));
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);
			System.out.println("Table created successfully..");

			System.out.println("Done");

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addEmptyLine(Document document, int i) {
		
	}
}
