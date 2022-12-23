package siddharth;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class AppTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://www.amazon.in/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("TV, Appliances, Electronics")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Televisions")).click();
            page.locator("#s-refinements").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Samsung"))
                    .click();
            page.locator("#a-autoid-0-announce").getByText("Sort by:").click();
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Price: High to Low"))
                    .getByText("Price: High to Low").click();

            Page page2 = page.waitForPopup(new Runnable() {
                public void run() {
                    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung")).nth(2).click();

                }
            });
            page2.waitForLoadState();
            System.out.println(page2.title());
            page2.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("About this item")).click();
            browser.close();
            playwright.close();
        }
    }
}