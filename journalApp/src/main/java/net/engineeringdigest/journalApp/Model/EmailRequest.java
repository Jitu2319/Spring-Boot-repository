package net.engineeringdigest.journalApp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailRequest {
	private String to;
	private String subject;
	private String from;
	private String body;

}
