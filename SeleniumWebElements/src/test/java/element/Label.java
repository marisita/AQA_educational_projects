package element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static constant.Attribute.ElementName.LABEL;
import static constant.Attribute.LoggerMessage.CANNOT_FIND_ELEMENT;

public class Label extends WebElementBase {

    private static final Logger LOGGER = LogManager.getLogger(Label.class);

    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        if (this.getWebElement().isDisplayed()) {
            return this.getWebElement().getText();
        } else {
            LOGGER.info(CANNOT_FIND_ELEMENT.toString(), LABEL.toString());
            throw new NoSuchElementException(CANNOT_FIND_ELEMENT.toString().concat(LABEL.toString()));
        }
    }

    public static boolean containsText(List<Label> labels, String text) {
        for (Label label: labels) {
            if (label.getText().toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static List<Label> getLabels(List<WebElement> webElements) {
        List<Label> labels = new ArrayList<>();
        for (WebElement webElement: webElements) {
            labels.add(new Label(webElement));
        }
        return labels;
    }
}
