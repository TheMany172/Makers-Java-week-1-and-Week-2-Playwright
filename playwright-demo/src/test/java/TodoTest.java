import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TodoTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;


    // in TodoTest.java

    @Test
    void shouldLoadHomepage() {
        page.navigate("https://todomvc.com");
        // Now we are on the TodoMVC homepage.
        // We'll write the rest of our code here!

    }

// Exercise addon

    @Test
    void testgithubbutton(){
        page.navigate("https://todomvc.com");
        Locator githubButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View on GitHub"));
        // Get the text content of the specified element
        System.out.println(githubButton.textContent());
    }

    @Test
    void reactlink(){
        page.navigate("https://todomvc.com");
        Locator reactlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setExact(true).setName("React"));
        reactlink.click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("react.png")));
        System.out.println(page.title());
    }


//    Locator storeClick = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setExact(true).setName("ABOUT"));
    @Test
    void testjavascripttab(){
        page.navigate("https://todomvc.com");
        Locator JStab = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("JavaScript"));
        Locator content1 = page.getByText("ExamplesJavaScriptCompile-to-JSLabs These are examples written in pure JavaScrip");
        System.out.println(JStab.textContent());
        System.out.println(content1.textContent());
//        page.click("JavaScript");
//        Locator content2 = page.getByText("ExamplesJavaScriptCompile-to-JSLabs These are examples written in pure JavaScrip");
//        System.out.println(content2.textContent());
        // Get the text content of the specified element
    }


    @Test
    void assertExerciseTest() {
        page.navigate("https://todomvc.com/examples/react/#/");
        assertThat(page).hasTitle("React • TodoMVC");

        Locator textbar = page.getByPlaceholder("What needs to be done?");
        textbar.click();
        textbar.type("Buy some milk");
        page.keyboard().press("Enter");

        Locator oneitemleft = page.getByText("1 item leftAll Active Completed");
        assertThat(oneitemleft).hasText("1 item leftAll Active Completed");

//        page.pause();
        Locator toggleone = page.locator("input.toggle");
        toggleone.click();

        Locator zeroitems = page.getByText("0 items leftAll Active CompletedClear completed");
        assertThat(zeroitems).hasText("0 items leftAll Active CompletedClear completed");
//        Locator testvar = page.locator("xpath=//span/form/input[@type='checkbox']");
//        Locator testvar = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Buy some milk"));
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("test.png")));
//        testvar.getByRole(AriaRole.CHECKBOX).check();





//        page.getByRole(AriaRole.LISTITEM).filter().getByRole(AriaRole.CHECKBOX).check();
//
//        Locator checkcircle = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Buy some milk"));
//        checkcircle.check();






//        Locator JStab = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("JavaScript"));
//        Locator content1 = page.getByText("ExamplesJavaScriptCompile-to-JSLabs These are examples written in pure JavaScrip");
//        System.out.println(JStab.textContent());
//        System.out.println(content1.textContent());
    }


//    @Test
//    void shouldPrintPageTitle() {
//        page.navigate("https://makers.tech");
//        System.out.println(page.title());
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