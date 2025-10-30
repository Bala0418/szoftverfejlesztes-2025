package com.nye.pageObjects;

import com.nye.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@Component
public class CommunitiesPage extends CommonPageObject{
    public CommunitiesPage(WebDriverFactory factory) {
        super(factory);
    }

    @FindBy(className = "evnt-search-filter")
    private WebElement searchBar;

    @FindBy(className = "evnt-community-card")
    private List<WebElement> communityCards;

    @FindBy(css = ".evnt-community-card .evnt-name-wrapper")
    private List<WebElement> communityCardTitles;

    public void pageIsLoaded() {
        assertTrue(searchBar.isDisplayed());
    }

    public void isFirstCommunityCardPresent() {
        assertTrue(communityCards.getFirst().isDisplayed());
    }

    public void assertNthCommunityCardTitle(int nthCard, String title) {
        assertEquals(communityCardTitles.get(nthCard).getText(), title);
    }
}
