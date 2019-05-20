package io.github.cristaling.university.vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.bilete.ro/mvc/Account/Register")
public class RegisterPage extends PageObject {

    @FindBy(id = "Email")
    private WebElementFacade emailField;

    @FindBy(id = "Password")
    private WebElementFacade passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElementFacade confirmPasswordField;

    @FindBy(xpath = "/html/body/main/form/div[5]/div/input")
    private WebElementFacade registerButton;

    @FindBy(xpath = "/html/body/main/form/div[1]/div/div/ul/li[2]")
    private WebElementFacade passwordError;

    public void enterEmail(String email) {
        emailField.click();
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.type(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordField.click();
        confirmPasswordField.type(password);
    }

    public void pressRegister() {
        registerButton.click();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }

}
