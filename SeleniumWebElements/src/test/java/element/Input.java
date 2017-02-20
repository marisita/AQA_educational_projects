package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import static constant.ElementName.INPUT;
import static constant.LoggerMessage.*;

public class Input extends WebElementBase {

    private static final Logger LOGGER = LogManager.getLogger(Input.class);

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void fillInput(String text) {
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
