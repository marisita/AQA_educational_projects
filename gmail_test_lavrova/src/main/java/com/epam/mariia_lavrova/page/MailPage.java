package com.epam.mariia_lavrova.page;

import com.epam.mariia_lavrova.helper.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.mariia_lavrova.constant.ElementName.LETTER_SUBJECT_LINK;
import static com.epam.mariia_lavrova.constant.ElementName.WRITE_BUTTON;
import static com.epam.mariia_lavrova.constant.Locator.LETTER_SUBJECT_LINK_LOCATOR;
import static com.epam.mariia_lavrova.constant.Locator.WRITE_BUTTON_LOCATOR;
import static com.epam.mariia_lavrova.constant.TestData.SUBJECT;

public class MailPage extends BasePage {

    @FindBy(xpath = WRITE_BUTTON_LOCATOR)
    private WebElement writeButton;

    @FindBy(xpath = LETTER_SUBJECT_LINK_LOCATOR)
    private WebElement letterSubjectLink;

    public NewLetterPage clickWriteButton() {
        Action.click(writeButton, WRITE_BUTTON, pageName);
        return new NewLetterPage();
    }

    public MailPage refreshPage() {
        Action.refreshPage(pageName);
        return this;
    }

    public MailPage assertLetterTheSame() {
        Action.assertText(letterSubjectLink, SUBJECT, LETTER_SUBJECT_LINK, pageName);
        return this;
    }
 }
