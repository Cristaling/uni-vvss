package io.github.cristaling.university.vvss.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.bilete.ro/cauta/")
public class EventsPage extends PageObject {

    public List<String> getEvents() {
        WebElementFacade eventsList = find(By.xpath("/html/body/main/section[2]/div/div[1]/div[1]"));
        return eventsList.findElements(By.className("ev-thumb-title")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getTitle() {
        WebElementFacade title = find(By.xpath("/html/body/h1"));
        return  title.getText();
    }
}
