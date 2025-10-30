package com.nye.stepdefinitions;

import com.nye.factory.WebDriverFactory;
import com.nye.pageObjects.CommunitiesPage;
import com.nye.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions {
    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private HomePage homePage;

    @Autowired
    private CommunitiesPage communitiesPage;

    @Given("the main page is opened")
    public void mainPageIsOpened() {
        webDriverFactory.getInstance().get("https://wearecommunity.io/");
    }

    @When("the Communities button is clicked on")
    public void theCommunitiesButtonIsClickedOn() {
        homePage.clickOnCommunitiesButton();
    }

    @Then("the page should be loaded")
    public void thePageShouldBeLoaded() {
        communitiesPage.pageIsLoaded();
    }

    @When("the first card content is checked")
    public void theFirstCardContentIsChecked() {

    }

    @Then("then card should be present")
    public void thenCardShouldBePresent() {
        communitiesPage.isFirstCommunityCardPresent();
    }

    @And("the title of the {int}. card should be {string}")
    public void theTitleOfTheCardShouldBe(int nth, String title) {
        communitiesPage.assertNthCommunityCardTitle(nth-1, title);
    }
}
