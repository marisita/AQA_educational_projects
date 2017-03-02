package com.epam.mariia_lavrova.page;

import com.epam.mariia_lavrova.helper.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.mariia_lavrova.constant.ElementName.EMAIL_INPUT;
import static com.epam.mariia_lavrova.constant.ElementName.NEXT_BUTTON;
import static com.epam.mariia_lavrova.constant.Locator.EMAIL_INPUT_LOCATOR;
import static com.epam.mariia_lavrova.constant.Locator.NEXT_BUTTON_LOCATOR;

public class EmailInputPage extends BasePage {

    private String pageName = this.getClass().getName();

    @FindBy(xpath = EMAIL_INPUT_LOCATOR)
    private WebElement emailInput;

    @FindBy(xpath = NEXT_BUTTON_LOCATOR)
    private WebElement nextButton;

    public EmailInputPage fillEmailInput(String email) {
        Action.fillInput(emailInput, email, EMAIL_INPUT, pageName);
        return this;
    }

    public PasswordInputPage clickNextButton() {
        Action.click(nextButton, NEXT_BUTTON, pageName);
        return new PasswordInputPage();
    }
}
