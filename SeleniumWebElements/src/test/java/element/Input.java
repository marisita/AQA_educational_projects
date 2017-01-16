package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import static constant.Attribute.ElementName.INPUT;
import static constant.Attribute.LoggerMessage.CANNOT_FIND_ELEMENT;
import static constant.Attribute.LoggerMessage.CLEARED;
import static constant.Attribute.LoggerMessage.INPUTTED;

public class Input extends WebElementBase {

    private static final Logger LOGGER = LogManager.getLogger(Input.class);

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void input(String text) {
        if (this.getWebElement().isDisplayed()){
            this.getWebElement().clear();
            LOGGER.info(CLEARED.toString(), INPUT.toString());
            this.getWebElement().sendKeys(text);
            LOGGER.info(INPUTTED.toString(), INPUT.toString());
        } else {
            LOGGER.info(CANNOT_FIND_ELEMENT.toString(), INPUT.toString());
        }
    }

    public void clear() {
        if (this.getWebElement().isDisplayed()) {
            this.getWebElement().clear();
            LOGGER.info(CLEARED.toString(), INPUT.toString());
        } else {
            LOGGER.info(CANNOT_FIND_ELEMENT.toString(), INPUT.toString());
        }
    }
}
