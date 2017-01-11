package validator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static constants.ValidatorMessage.Register.*;
import static utils.TestData.*;

public class RegisterValidatorTest {

    private RegisterValidator registerValidator;
    private List<String> errors;

    @BeforeMethod
    public void setUp() throws Exception {
        registerValidator = new RegisterValidator();
        errors = new ArrayList<>();
    }

    @Test
    public void testValidateWhenUserValidThenListIsEmpty() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_VALID);
        Assert.assertEquals(errors.isEmpty(), true);
    }

    @Test
    public void testValidateWhenUserInvalidThenListIsNotEmpty() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_INVALID_LOGIN);
        Assert.assertEquals(errors.isEmpty(), false);
    }

    @Test
    public void testValidateWhenLoginInvalidThenListHaveError() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_INVALID_LOGIN);
        Assert.assertEquals(errors.get(0), LOGIN_CONTAINS_FORBIDDEN_SYMBOL);
    }

    @Test
    public void testValidateWhenPasswordHasInvalidLengthThenListHaveError() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_INVALID_PASSWORD);
        Assert.assertEquals(errors.get(0), INVALID_PASSWORD_LENGTH);
    }

    @Test
    public void testValidateWhenPasswordsNotMatchesThenListHaveError() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_INVALID_PASSWORDS);
        Assert.assertEquals(errors.get(0), PASSWORDS_NOT_MATCHES);
    }

    @Test
    public void testValidateWhenEmailInvalidThenListHaveError() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_INVALID_EMAIL);
        Assert.assertEquals(errors.get(0), INVALID_EMAIL);
    }

    @Test
    public void testValidateWhenEmailEmptyThenListHaveError() throws Exception {
        errors = registerValidator.validate(TEST_USER_BEAN_EMPTY_EMAIL);
        Assert.assertEquals(errors.get(0), EMPTY_EMAIL);
    }
}