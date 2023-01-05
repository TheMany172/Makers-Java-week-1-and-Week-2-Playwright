package org.example;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class GovUKTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @Test
    void reactlinkVersion2() {
        GovUK govuk1 = new GovUK(page);
        govuk1.navigate();
        govuk1.searchFor("car tax");
        govuk1.clickTaxYourVehicle();
        govuk1.clickCookiesAccept();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("taxVersion2.png")));
//        govuk1.screenGrab();
    }

    @Test
    void reactlink() {
        page.navigate("http://www.gov.uk/");
        Locator searchBar = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search"));
        searchBar.click();
        searchBar.type("car tax");

        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search GOV.UK"));
        searchButton.click();

        Locator taxYourVehicle = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setExact(true).setName("Tax your vehicle"));
        taxYourVehicle.click();

        Locator cookieclick = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setExact(true).setName("Accept additional cookies"));
        cookieclick.click();

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("tax.png")));

    }






    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}

