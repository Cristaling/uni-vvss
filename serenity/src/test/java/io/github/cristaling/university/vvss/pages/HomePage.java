package io.github.cristaling.university.vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.bilete.ro/")
public class HomePage extends PageObject {

    @FindBy(xpath = "/html/body/nav/div[2]/div/div[5]/div/div/form/div/input")
    private WebElementFacade searchField;

    @FindBy(xpath = "/html/body/nav/div[2]/div/div[5]/div/div/form/div/button")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id=\"logoutForm\"]/a")
    private WebElementFacade logoutForm;

    public void enterKeyword(String keyword) {
        searchField.click();
        searchField.type(keyword);
    }

    public void searchEvents() {
        searchButton.click();
    }

    public String getLogoutFormText() {
        return logoutForm.getText();
    }

}
