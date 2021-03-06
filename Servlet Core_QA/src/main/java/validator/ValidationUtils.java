package validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	
	private static final String LOGIN_OR_PASSWORD_FORBIDDEN_SYMBOLS = "[^A-Za-z0-9_]";
	private static final String FIRSTNAME_OR_LASTNAME_FORBIDDEN_SYMBOLS = "[^A-Za-z]";
	private static final String EMAIL_MATCHES_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
			+ "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final int MIN_PASSWORD_LENGTH = 5;
	private static final int MAX_PASSWORD_LENGTH = 20;
	private static final int MIN_LOGIN_LENGTH = 5;
	private static final int MAX_LOGIN_LENGTH = 20;

	public static boolean isLoginOrPasswordNotContainForbiddenSymbol(String line) {

		String regexp = LOGIN_OR_PASSWORD_FORBIDDEN_SYMBOLS;
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(line);
		return !matcher.find();
	}

	public static boolean isFirstNameOrLastNameNotContainForbiddenSymbol(String line) {

		String regexp = FIRSTNAME_OR_LASTNAME_FORBIDDEN_SYMBOLS;
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(line);
		return !matcher.find();
	}

	public static boolean isEmailMatchPattern(String line) {

		String regexp = EMAIL_MATCHES_PATTERN;
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(line);
		return matcher.find();
	}

	public static boolean isNotEmpty(String line) {
		return line != null && !line.isEmpty();
	}

	public static boolean isPasswordsAreMatched(String password, String repeatedPassword) {
		return password.equals(repeatedPassword);
	}

	public static boolean isPasswordHasValidLength(String password) {
		return  password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH;
	}

	public static boolean isLoginHasValidLength(String login) {
		return  login.length() >= MIN_LOGIN_LENGTH && login.length() <= MAX_LOGIN_LENGTH;
	}
}
