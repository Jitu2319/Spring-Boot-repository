package net.engineeringdigest.journalApp.Model;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@Builder
public class Users {

	@Id
	private ObjectId id;

	@NonNull
	@Indexed(unique = true)
	private String userName;
	@NonNull
	private String password;

	@DBRef
	private List<Journal> journalEntries = new ArrayList<>();

	private List<String> roles;

}
