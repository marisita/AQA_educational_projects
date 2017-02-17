package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import static constant.ElementName.LINK;
import static constant.LoggerMessage.CANNOT_FIND_ELEMENT;
import static constant.LoggerMessage.CLICKED;

public class Link extends WebElementBase {

    private static final Logger LOGGER = LogManager.getLogger(Link.class);

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        if (this.getWebElement().isDisplayed()){
            this.getWebElement().click();
            LOGGER.info(CLICKED.toString(), LINK.toString());
        } else {
            LOGGER.error(CANNOT_FIND_ELEMENT.toString(), LINK.toString());
        }
    }
}
