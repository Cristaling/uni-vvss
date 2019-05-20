package io.github.cristaling.university.vvss.steps.serenity;

import io.github.cristaling.university.vvss.pages.HomePage;
import io.github.cristaling.university.vvss.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class EndUserLoginSteps {

    LoginPage loginPage;
    HomePage homePage;

    @Step
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Step
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step
    public void login() {
        loginPage.pressLogin();
    }

    @Step
    public void shouldBeLoggedIn(String email) {
        assertThat(homePage.getLogoutFormText(), containsString(email));
    }

    @Step
    public void openLoginPage() {
        loginPage.open();
    }

    @Step
    public void shouldGetError() {
        assertThat(loginPage.getEmailError(), containsString("The Email field is not a valid e-mail address."));
    }

}