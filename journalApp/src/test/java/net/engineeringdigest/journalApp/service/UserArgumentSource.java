package net.engineeringdigest.journalApp.service;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import net.engineeringdigest.journalApp.Model.Users;

public class UserArgumentSource implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(Arguments.of(Users.builder().userName("Jitendra").password("Jitendra").build()),
				Arguments.of(Users.builder().userName("Rohit").password("Rohit").build()));
	}

}
