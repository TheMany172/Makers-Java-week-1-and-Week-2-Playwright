import com.microsoft.playwright.*;

import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.Arrays;

public class firefoxexercise {
    public static <Array> void main(String[] args) {
        // Create a new instance of Playwright
        Playwright playwright = Playwright.create();

        // Use Playwright to open a new instance of Chromium
        Browser firefox1 = playwright.firefox().launch();

        // Open a new virtual page (tab) in your Chromium instance
        Page page = firefox1.newPage();

        // Instruct the new page to browse to the Makers website
        page.navigate("https://store.steampowered.com/");

        // Take a screenshot of what's currently on the page,
        // and store it in a file called 'makers.png'
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("steamstore.png")));

        // Find the title of the webpage (the value inside the HTML
        // <title> element) and print it to the terminal
        String titlehere = page.title();
        String arr[] = titlehere.split(" ");
        String result = arr[0];
        System.out.println(result);

        // Close down Playwright and end the test
        playwright.close();
    }
}