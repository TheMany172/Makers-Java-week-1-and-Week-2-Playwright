package org.example;
import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.util.Scanner;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class ChallengeDownload {


    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;



    @Test
    void DownloadTest() {
        page.navigate("https://the-internet.herokuapp.com/download");
        Download myFile = page.waitForDownload(() -> {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("some-file.txt")).click();});

        myFile.saveAs(Paths.get("/Users/adamlittle/IdeaProjects/playwright-demo/some-file.txt"));

//        System.out.println(myFile.path());

        File file1 = new File ("some-file.txt");
        try (Scanner scanner1 = new Scanner(file1)) {

            while (scanner1.hasNextLine()) {
                System.out.println(scanner1.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
