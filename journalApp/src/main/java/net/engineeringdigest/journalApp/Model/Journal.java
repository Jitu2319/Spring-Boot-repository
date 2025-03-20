package net.engineeringdigest.journalApp.Model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("journal_entries")
@Data
@NoArgsConstructor
public class Journal {

	@Id
	private ObjectId id;
	@NonNull
	private String name;
	private String content;
	private LocalDateTime date;

}
