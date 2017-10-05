package com.epam.mariia_lavrova.page;

import com.epam.mariia_lavrova.helper.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.mariia_lavrova.constant.ElementName.PASSWORD_INPUT;
import static com.epam.mariia_lavrova.constant.ElementName.SING_IN_BUTTON;
import static com.epam.mariia_lavrova.constant.Locator.PASSWORD_BUTTON_LOCATOR;
import static com.epam.mariia_lavrova.constant.Locator.SIGN_IN_BUTTON_LOCATOR;

public class PasswordInputPage extends BasePage {

    @FindBy(xpath = PASSWORD_BUTTON_LOCATOR)
    private WebElement passwordInput;

    @FindBy(xpath = SIGN_IN_BUTTON_LOCATOR)
    private WebElement singInButton;

    public PasswordInputPage fillPasswordInput(String password) {
        Action.fillInput(passwordInput, password, PASSWORD_INPUT, pageName);
        return this;
    }

    public MailPage clickSingInButton() {
        Action.click(singInButton, SING_IN_BUTTON, pageName);
        return new MailPage();
    }
}
