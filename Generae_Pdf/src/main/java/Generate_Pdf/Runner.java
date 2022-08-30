package Generate_Pdf;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Generate_Pdf.service.PdfFileServiceClass;

@Component
public class Runner implements ApplicationRunner {

	private PdfFileServiceClass pdfservice;

	public Runner(PdfFileServiceClass pdfservice) {
		this.pdfservice = pdfservice;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application started to Run");
		pdfservice.pdfCreation();
		System.out.println("Pdf is generated. Please check the folder.");
	}

}
