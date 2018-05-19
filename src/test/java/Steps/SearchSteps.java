package Steps;

import Pages.SearchPage;
import org.openqa.selenium.Keys;


public class SearchSteps extends SearchPage {

    public void inputSearch(String value) {
        driver.WaitElementToBeVisibilityOf(SearchButton,3);
        driver.WaitElementToBeClickable(SearchButton,3);
        SearchButton.click();
        InputSearch.sendKeys(value);
        InputSearch.sendKeys(Keys.ENTER);
    }
}
