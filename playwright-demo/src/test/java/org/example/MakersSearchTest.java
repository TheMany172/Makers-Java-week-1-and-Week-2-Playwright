package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class MakersSearchTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;



    @Test
    void shouldFindSearchResultsForJava() {
        MakersSearchPage searchPage = new MakersSearchPage(page);
        searchPage.navigate();
        searchPage.searchFor("java");
        assertThat(searchPage.getSearchResultsHeading()).containsText("Results for java");
    }

    @Test
    void shouldNotFindSearchResultsForBadger() {
        MakersSearchPage searchPage = new MakersSearchPage(page);
        searchPage.navigate();
        searchPage.searchFor("badger");
        assertThat(searchPage.getSearchResultsHeading()).containsText("No results for badger");
    }






//    @Test
//    void shouldFindSearchResultsForJava() {
//        page.navigate("https://makers.tech");
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first().click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).fill("java");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).press("Enter");
//        assertThat(page.locator("h1")).containsText("Results for java");
//    }
//
//    @Test
//    void shouldNotFindSearchResultsForBadger() {
//        page.navigate("https://makers.tech");
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first().click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).fill("badger");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).press("Enter");
//        assertThat(page.locator("h1")).containsText("No results for badger");
//    }



    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
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
