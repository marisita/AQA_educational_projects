package page;

import driver.ChromeDriverManager;
import element.Label;
import org.openqa.selenium.By;

import static data.TestData.Selector.CATEGORY_TEXT_SELECTOR;

public class CategoryPage extends BasePage {

    private Label labelCategory;

    private void findCategoryLabel() {
        By buCategoryLabel = By.cssSelector(CATEGORY_TEXT_SELECTOR.toString());
        labelCategory = new Label(ChromeDriverManager.getDriver().findElement(buCategoryLabel));
    }

    public String getLabelCategory() {
        findCategoryLabel();
        return labelCategory.getText();
    }
}
