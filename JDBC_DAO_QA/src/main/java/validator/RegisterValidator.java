package validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servlet.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

import static constants.ValidatorMessage.Register.*;

public class RegisterValidator {

    private static final Logger LOGGER = LogManager.getLogger(RegisterValidator.class);

    public List<String> validate(UserBean userBean) {
        List<String> errors = new ArrayList<>();
        errors.addAll(validateLogin(userBean.getLogin()));
        errors.addAll(validatePassword(userBean.getPassword(), userBean.getRepeatedPassword()));
        errors.addAll(validateFirstName(userBean.getFirstName()));
        errors.addAll(validateLastName(userBean.getLastName()));
        errors.addAll(validateEmail(userBean.getEmail()));
        return errors;
    }

    private List<String> validateLogin(String login) {

        List<String> errors = new ArrayList<>();

        if (ValidationUtils.isNotEmpty(login)) {
            if (!ValidationUtils.isLoginHasValidLength(login)) {
                LOGGER.error(INVALID_LOGIN_LENGTH);
                errors.add(INVALID_LOGIN_LENGTH);
            }
            if (!ValidationUtils.isLoginOrPasswordNotContainForbiddenSymbol(login)) {
                LOGGER.error(LOGIN_CONTAINS_FORBIDDEN_SYMBOL);
                errors.add(LOGIN_CONTAINS_FORBIDDEN_SYMBOL);
            }
        } else {
            LOGGER.error(EMPTY_LOGIN);
            errors.add(EMPTY_LOGIN);
        }
        return errors;
    }

    private List<String> validatePassword(String password, String repeatedPassword) {

        List<String> errors = new ArrayList<>();

        if (ValidationUtils.isNotEmpty(password)) {
            if (!ValidationUtils.isPasswordHasValidLength(password)) {
                LOGGER.error(INVALID_PASSWORD_LENGTH);
                errors.add(INVALID_PASSWORD_LENGTH);
            }
            if (!ValidationUtils.isLoginOrPasswordNotContainForbiddenSymbol(password)) {
                LOGGER.error(PASSWORD_CONTAINS_FORBIDDEN_SYMBOL);
                errors.add(PASSWORD_CONTAINS_FORBIDDEN_SYMBOL);
            }
            if (!ValidationUtils.isPasswordsAreMatched(password, repeatedPassword)) {
                LOGGER.error(PASSWORDS_NOT_MATCHES);
                errors.add(PASSWORDS_NOT_MATCHES);
            }
        } else {
            errors.add(EMPTY_PASSWORD);
        }
        return errors;
    }

    private List<String> validateFirstName(String firstName) {

        List<String> errors = new ArrayList<>();

        if (ValidationUtils.isNotEmpty(firstName)) {
            if (!ValidationUtils.isFirstNameOrLastNameNotContainForbiddenSymbol(firstName)) {
                LOGGER.error(FIRST_NAME_CONTAINS_FORBIDDEN_SYMBOL);
                errors.add(FIRST_NAME_CONTAINS_FORBIDDEN_SYMBOL);
            }
        } else {
            LOGGER.error(EMPTY_FIRST_NAME);
            errors.add(EMPTY_FIRST_NAME);
        }
        return errors;
    }

    private List<String> validateLastName(String lastName) {

        List<String> errors = new ArrayList<>();

        if (ValidationUtils.isNotEmpty(lastName)) {
            if (!ValidationUtils.isFirstNameOrLastNameNotContainForbiddenSymbol(lastName)) {
                LOGGER.error(LAST_NAME_CONTAINS_FORBIDDEN_SYMBOL);
                errors.add(LAST_NAME_CONTAINS_FORBIDDEN_SYMBOL);
            }
        } else {
            LOGGER.error(EMPTY_LAST_NAME);
            errors.add(EMPTY_LAST_NAME);
        }
        return errors;
    }

    private List<String> validateEmail(String email) {

        List<String> errors = new ArrayList<>();

        if (ValidationUtils.isNotEmpty(email)) {
            if (!ValidationUtils.isEmailMatchPattern(email)) {
                LOGGER.error(INVALID_EMAIL);
                errors.add(INVALID_EMAIL);
            }
        } else {
            LOGGER.error(EMPTY_EMAIL);
            errors.add(EMPTY_EMAIL);
        }
        return errors;
    }

}
