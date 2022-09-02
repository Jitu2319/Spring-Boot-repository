package Generate_Pdf;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import Generate_Pdf.utility.GeneratePdf;
import Generate_Pdf.utility.ReadExcelDemo;

@SpringBootTest
class GeneraePdf1ApplicationTests {

	@Test
	void contextLoads() {

		GeneratePdf pdf = new GeneratePdf();
		pdf.writeUsingIText();
//		ReadExcelDemo read = new ReadExcelDemo();
//		read.readExcel();
	}

}
