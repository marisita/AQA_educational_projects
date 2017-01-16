package element;

import org.openqa.selenium.WebElement;

public abstract class WebElementBase {

    private WebElement webElement;

    public WebElementBase(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }
}
