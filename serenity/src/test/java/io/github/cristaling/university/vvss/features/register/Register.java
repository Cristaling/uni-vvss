package io.github.cristaling.university.vvss.features.register;

import io.github.cristaling.university.vvss.steps.serenity.EndUserRegisterSteps;
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
public class Register {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserRegisterSteps endUserRegisterSteps;

    @Issue("#REGISTERValid")
    @Test
    public void successfulRegister() {

        String email = "a" + System.currentTimeMillis() + "@yahoo.com";
        String password = "@qwerty@asdf";

        endUserRegisterSteps.openRegisterPage();

        By byclass = By.className("preloader-overlay done");
        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byclass));

        endUserRegisterSteps.enterEmail(email);
        endUserRegisterSteps.enterPassword(password);
        endUserRegisterSteps.enterConfirmedPassword(password);
        endUserRegisterSteps.startRegister();

        endUserRegisterSteps.shouldBeLoggedIn(email);
    }

    @Issue("#REGISTERNotValid")
    @Test
    public void register_should_get_error() {

        String email = "a";
        String password = "a";

        endUserRegisterSteps.openRegisterPage();

        endUserRegisterSteps.enterEmail(email);
        endUserRegisterSteps.enterPassword(password);
        endUserRegisterSteps.enterConfirmedPassword(password);
        endUserRegisterSteps.startRegister();

        endUserRegisterSteps.shouldGetError();
    }


}
