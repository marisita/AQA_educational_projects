package com.epam.mariia_lavrova.task5.waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Condition {

    private static Condition instance = new Condition();

    private Condition() {

    }

    public static Condition getInstance() {
        return instance;
    }

    public ExpectedCondition<Boolean> waitForElementHasText(final WebElement webElement, final String compareString) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return webElement.getText().toUpperCase().contains(compareString.toUpperCase());
            }
        };
    }

}

