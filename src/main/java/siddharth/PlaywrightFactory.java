package siddharth;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName) {

        System.out.println("browser is " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Enter the browser name as chrome or chromium");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.duck.com");
        return page;

    }
}
