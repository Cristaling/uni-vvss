package io.github.cristaling.university.vvss.steps.serenity;

import io.github.cristaling.university.vvss.pages.EventsPage;
import io.github.cristaling.university.vvss.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class EndUserSearchSteps {

    HomePage homePage;
    EventsPage eventsPage;

    @Step
    public void enters(String keyword) {
        homePage.enterKeyword(keyword);
    }

    @Step
    public void startSearch() {
        homePage.searchEvents();
    }

    @Step
    public void shouldSeeEvent(String event) {
        assertThat(eventsPage.getEvents(), hasItem(containsString(event)));
    }

    @Step
    public void openHomepage() {
        homePage.open();
    }

    @Step
    public void searchFor(String event) {
        enters(event);
        startSearch();
    }

    @Step
    public void shouldGetError() {
        System.out.println(eventsPage.getTitle() +  "****");
        assertThat(eventsPage.getTitle(), containsString("500 Problema tehnica"));
    }

}