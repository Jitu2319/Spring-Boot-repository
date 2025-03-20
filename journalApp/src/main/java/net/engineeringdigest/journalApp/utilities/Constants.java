package net.engineeringdigest.journalApp.utilities;

import java.util.ResourceBundle;

public class Constants {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("applicationresource");

	public static final String EMAIL_PATTERN = bundle.getString("email.regex");
	public static final String PASSWORD_PATTERN = bundle.getString("password.regex");
	
	public static final String EMAIL_FROM = bundle.getString("EMAIL_FROM");
    public static final String EMAIL_TO = bundle.getString("EMAIL_TO");
    public static final String EMAIL_SUBJECT = bundle.getString("EMAIL_SUBJECT");
    public static final String EMAIL_BODY = bundle.getString("EMAIL_BODY");
    public static final String FILE_PATH = bundle.getString("FILE_PATH");
    public static final String FILE_NAME = bundle.getString("FILE_NAME");
}
