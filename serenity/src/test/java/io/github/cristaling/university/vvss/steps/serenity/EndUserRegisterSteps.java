package io.github.cristaling.university.vvss.steps.serenity;

import io.github.cristaling.university.vvss.pages.HomePage;
import io.github.cristaling.university.vvss.pages.RegisterPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class EndUserRegisterSteps {

    RegisterPage registerPage;
    HomePage homePage;

    @Step
    public void enterEmail(String email) {
        registerPage.enterEmail(email);
    }

    @Step
    public void enterPassword(String password) {
        registerPage.enterPassword(password);
    }

    @Step
    public void enterConfirmedPassword(String password) {
        registerPage.confirmPassword(password);
    }

    @Step
    public void startRegister() {
        registerPage.pressRegister();
    }

    @Step
    public void shouldBeLoggedIn(String email) {
        assertThat(homePage.getLogoutFormText(), containsString(email));
    }

    @Step
    public void openRegisterPage() {
        registerPage.open();
    }

    @Step
    public void shouldGetError() {
        assertThat(registerPage.getPasswordError(), containsString("Parola trebuie sa aiba minim 6 caractere"));
    }

}
