package io.github.cristaling.university.vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.bilete.ro/mvc/Account/Login")
public class LoginPage extends PageObject {

    @FindBy(id = "Email")
    private WebElementFacade emailField;

    @FindBy(id = "Password")
    private WebElementFacade passwordField;

    @FindBy(xpath = "/html/body/main/div[2]/div[2]/section/form/div[5]/div/input")
    private WebElementFacade loginButton;

    @FindBy(id = "Email-error")
    private WebElementFacade emailError;

    public void enterEmail(String email) {
        emailField.click();
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.type(password);
    }

    public void pressLogin() {
        loginButton.click();
    }

    public String getEmailError() {
        return emailError.getText();
    }

}
