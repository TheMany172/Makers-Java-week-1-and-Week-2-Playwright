import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeAssertions {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @Test
    void challengeTestAssertions() {
        page.navigate("https://makers.tech/");
//        assertThat(page).hasTitle("React • TodoMVC");
        String pageTitle = page.title();
        Boolean goodTitle = pageTitle.contains("Change Your Life");
        assertEquals(true, goodTitle);

        Locator codeOfConductLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Code of Conduct"));
        assertThat(codeOfConductLink).hasText("Code of Conduct");
        codeOfConductLink.click();

        assertThat(page).hasURL("https://makers.tech/code-of-conduct/");
        String pageTitle2 = page.title();
        Boolean goodTitle2 = pageTitle2.contains("Code of Conduct");
        assertEquals(true, goodTitle2);

        page.navigate("https://makers.tech/");
        Locator faqLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first();
        faqLink.click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("FAQ_Page.png")));
        assertThat(page).hasURL("https://faq.makers.tech/en/knowledge");
        assertThat(page).hasTitle("Help Center");

        Locator searchTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers"));
        searchTextBox.click();
        searchTextBox.type("badger");
        page.keyboard().press("Enter");

        Locator noBadger = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("No results for badger"));
        assertThat(noBadger).hasText("No results for badger");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("noBadger.png")));
    }









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
