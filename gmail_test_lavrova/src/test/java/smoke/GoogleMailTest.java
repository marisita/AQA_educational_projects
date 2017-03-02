package smoke;

import base.BaseTest;
import com.epam.mariia_lavrova.page.EmailInputPage;
import org.testng.annotations.Test;

import static com.epam.mariia_lavrova.constant.TestData.*;

public class GoogleMailTest extends BaseTest {

    @Test
    public void testSendMailToCurrentUser() throws Exception {

        new EmailInputPage()
                .fillEmailInput(EMAIL)
                .clickNextButton()
                .fillPasswordInput(PASSWORD)
                .clickSingInButton()
                .clickWriteButton()
                .fillToInput(EMAIL)
                .fillSubjectInput(SUBJECT)
                .fillBodyInput(BODY)
                .clickSendButton()
                .refreshPage()
                .assertLetterTheSame();
    }
}