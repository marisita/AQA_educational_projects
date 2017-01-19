package com.epam.mariia_lavrova.task5.page;

import com.epam.mariia_lavrova.task5.driver.ChromeDriverManager;

public abstract class BasePage {

    public void open(String url) {
        ChromeDriverManager.getDriver().get(url);
    }
}
