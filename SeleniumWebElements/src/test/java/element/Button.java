package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import static constant.Attribute.ElementName.BUTTON;
import static constant.Attribute.LoggerMessage.CANNOT_FIND_ELEMENT;
import static constant.Attribute.LoggerMessage.CLICKED;

public class Button extends WebElementBase {

    private static final Logger LOGGER = LogManager.getLogger(Button.class);

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        if (this.getWebElement().isDisplayed()){
            this.getWebElement().click();
            LOGGER.info(CLICKED.toString(), BUTTON.toString());
        } else {
            LOGGER.error(CANNOT_FIND_ELEMENT.toString(), BUTTON.toString());
        }
    }
}
