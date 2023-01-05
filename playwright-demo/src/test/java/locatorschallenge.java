import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class locatorschallenge {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;


    // in TodoTest.java

    @Test
    void fav_website() {
        page.navigate("https://store.steampowered.com/");
        Locator categoryButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Categories"));
        System.out.println(categoryButton.textContent());

//.locator("#global_header")

        Locator storeClick = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setExact(true).setName("ABOUT"));
        storeClick.click();
//        page.click("#global_header");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("steamabout.png")));
        Locator aboutcontent = page.getByText("Steam is the ultimate destination for playing, discussing, and creating games.");
        System.out.println(aboutcontent.textContent());
//        page.locator("#global_header").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("ABOUT")).click();
//        Locator aboutcontent = page.getByText("Steam is the ultimate destination for playing, discussing, and creating games.");
//        System.out.println(aboutcontent.textContent());
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