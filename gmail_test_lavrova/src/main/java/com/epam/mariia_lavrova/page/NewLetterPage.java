package com.epam.mariia_lavrova.page;

import com.epam.mariia_lavrova.helper.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.mariia_lavrova.constant.ElementName.*;
import static com.epam.mariia_lavrova.constant.Locator.*;

public class NewLetterPage extends BasePage {

    @FindBy(xpath = TO_INPUT_LOCATOR)
    private WebElement toInput;

    @FindBy(xpath = SUBJECT_INPUT_LOCATOR)
    private WebElement subjectInput;

    @FindBy(xpath = BODY_INPUT_LOCATOR)
    private WebElement bodyInput;

    @FindBy(xpath = SEND_BUTTON_LOCATOR)
    private WebElement sendButton;

    public NewLetterPage fillToInput(String to) {
        Action.fillInput(toInput, to, TO_INPUT, pageName);
        return this;
    }

    public NewLetterPage fillSubjectInput(String subject) {
        Action.fillInput(subjectInput, subject, SUBJECT_INPUT, pageName);
        return this;
    }

    public NewLetterPage fillBodyInput(String body) {
        Action.fillInput(bodyInput, body, BODY_INPUT, pageName);
        return this;
    }

    public MailPage clickSendButton() {
        Action.click(sendButton, SEND_BUTTON, pageName);
        return new MailPage();
    }
}
