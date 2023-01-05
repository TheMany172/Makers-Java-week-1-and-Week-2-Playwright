import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class ChallengeDebugging {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(2000));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://makers.tech/");
            String pageTitle = page.title();
            Boolean goodTitle = pageTitle.contains("Change Your Life");
            assertEquals(true, goodTitle);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Code of Conduct")).click();
            String pageTitle2 = page.title();
            Boolean goodTitle2 = pageTitle2.contains("Code of Conduct");
            assertEquals(true, goodTitle2);

            page.navigate("https://makers.tech/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQs")).first().click();

            assertThat(page).hasURL("https://faq.makers.tech/en/knowledge");

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).fill("badger");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for answers")).press("Enter");

            Locator noBadger = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("No results for badger"));
            assertThat(noBadger).hasText("No results for badger");
        }
    }
}