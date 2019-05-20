package io.github.cristaling.university.vvss.features.login;

import io.github.cristaling.university.vvss.steps.serenity.EndUserLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(SerenityRunner.class)
public class Login {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserLoginSteps endUserLoginSteps;

    @Issue("#LOGINValid")
    @Test
    public void successfulLogin() {

        String email = "ucanbeatit@gmail.com";
        String password = "@qwerty@asdf";

        endUserLoginSteps.openLoginPage();

        By byclass = By.className("preloader-overlay done");
        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byclass));

        endUserLoginSteps.enterEmail(email);
        endUserLoginSteps.enterPassword(password);
        endUserLoginSteps.login();

        endUserLoginSteps.shouldBeLoggedIn(email);
    }

    @Issue("#LOGINNotValid")
    @Test
    public void invalidLogin() {

        String email = "a";
        String password = "a";

        endUserLoginSteps.openLoginPage();
        endUserLoginSteps.enterEmail(email);
        endUserLoginSteps.enterPassword(password);

        endUserLoginSteps.shouldGetError();
    }


}