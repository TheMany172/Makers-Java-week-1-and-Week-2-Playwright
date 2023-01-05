package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class emulationTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @Test
    void navGovUkCodeOfConduct() {
        page.navigate("https://makers.tech/");
        Locator CofC = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Code of Conduct"));
        CofC.hover();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("defualtCofC_onmakers.png")));
        assertThat(CofC).hasText("Code of Conduct");
    }

    @Test
    void navGovUkCodeOfConduct_mobile() {
        page.setViewportSize(390, 840);

        page.navigate("https://makers.tech/");
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Code of Conduct"))).isHidden();

        page.keyboard().press("End");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("smallResCofC_onmakers.png")));
        page.pause();
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


