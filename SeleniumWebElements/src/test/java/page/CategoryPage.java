package page;

import element.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.Selector.CATEGORY_TEXT_SELECTOR;


public class CategoryPage extends BasePage {

    @FindBy(css = CATEGORY_TEXT_SELECTOR)
    private WebElement labelCategoryWebElement;

    private Label labelCategory;

    private void findCategoryLabel() {
        labelCategory = new Label(labelCategoryWebElement);
    }

    public String getLabelCategory() {
        findCategoryLabel();
        return labelCategory.getText();
    }
}