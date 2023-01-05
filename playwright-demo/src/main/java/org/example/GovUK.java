package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class GovUK {
    private Page page;
    private Locator searchBar;
    private Locator taxYourVehicleLink;
    private Locator cookiesClick;
    private Locator screen;

    public GovUK (Page page) {
        this.page = page;
        this.searchBar = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search"));
        this.taxYourVehicleLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setExact(true).setName("Tax your vehicle"));
        this.cookiesClick = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setExact(true).setName("Accept additional cookies"));
//        this.screen = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("taxVersion2.png")));
    }

    public void navigate() {
        page.navigate("http://www.gov.uk/");
    }


    public void searchFor(String searchTerm) {
        searchBar.type(searchTerm);
        searchBar.press("Enter");
    }

    public void clickTaxYourVehicle () {
        this.taxYourVehicleLink.click();
    }

    public void clickCookiesAccept () {
        this.cookiesClick.click();
    }

//    public void screenGrab () {
//        this.screen;
//    }


}
