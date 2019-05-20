package io.github.cristaling.university.vvss.features.search;

import io.github.cristaling.university.vvss.steps.serenity.EndUserSearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class SearchEventByKeyword {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSearchSteps endUserSearchSteps;

    @Issue("#SEARCHValid")
    @Test
    public void searching_by_keyword_muzica_should_display_events() {

        endUserSearchSteps.openHomepage();

        endUserSearchSteps.searchFor("muzica");
        endUserSearchSteps.shouldSeeEvent("Concert Aniversar Nineta Popa - Orchestra De Muzica Populara");
    }

    @Issue("#SEARCHNotValid")
    @Test
    public void searching_by_keyword_a_should_display_error() {

        endUserSearchSteps.openHomepage();

        endUserSearchSteps.searchFor("a");
        endUserSearchSteps.shouldGetError();
    }


} 