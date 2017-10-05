package com.epam.mariia_lavrova.constant;

/**
 * Class contains the logger messages and fail messages for asserts
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */

public final class Message {

    public static final String INVALID_DRIVER_NAME = "Invalid driver name";

    public static final String PAGE_WAS_REFRESHED = "Page %s was refreshed";
    public static final String PAGE_WAS_NOT_REFRESHED = "Page %s was not refreshed";

    public static final String ELEMENT_CONTAINS_TEXT = "Element %s contains text '%s' on the page";
    public static final String ELEMENT_NOT_CONTAIN_TEXT = "Element %s does not contain test '%s'";

    public static final String ELEMENT_FROM_LIST_CONTAINS_TEXT = "Element from list of elements %s contains text '%s'";
    public static final String ANY_ELEMENT_FROM_LIST_NOT_CONTAIN_TEST = "Any element from list of elements %s does not contain test '%s'";

    public static final String ELEMENT_CLICKABLE_ON_THE_PAGE = "Element %s is clickable on the page %s";
    public static final String ELEMENT_NOT_CLICKABLE_ON_THE_PAGE = "Element %s is not clickable on the page %s";

    public static final String ELEMENT_IS_VISIBLE_ON_THE_PAGE = "Element %s is visible on the page %s";
    public static final String ELEMENT_NOT_VISIBLE_ON_THE_PAGE = "Element %s is not visible on the page %s";

    public static final String ELEMENT_WAS_CLICKED_ON_THE_PAGE = "Element %s was clicked on the page %s";
    public static final String ELEMENT_WAS_FILLED_WITH_VALUE_ON_THE_PAGE = "Element %s was filled with value on the page %s";

    private Message() {
    }
}
