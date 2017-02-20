package helper;

import element.Label;
import org.testng.Assert;

import java.util.List;

public class TestAction {

    public static void assertContains(String actualText, String expectedText) {

        Assert.assertTrue(containsText(actualText, expectedText));
    }

    public static void assertContains(List<Label> labels, String expectedText) {

        boolean contains = false;

        for (Label label : labels) {
            contains = containsText(label.getText(), expectedText);
        }

        Assert.assertTrue(contains);
    }

    private static boolean containsText(String actualText, String expectedText) {

        actualText = actualText.toLowerCase().replace(" ", "");
        expectedText = expectedText.toLowerCase().replace(" ", "");
        return actualText.contains(expectedText);
    }
}
