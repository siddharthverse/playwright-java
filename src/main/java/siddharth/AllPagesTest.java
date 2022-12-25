package siddharth;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class AllPagesTest {

    PlaywrightFactory pf;
    Page page;
    AllPages allPages;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        page = pf.initBrowser("chromium");
        allPages = new AllPages(page);
        
    }

    @Test
    public void homePageTest() {
        String title = allPages.getPageTitle();
        // String url = allPages.getPageURL();
        Assert.assertEquals(title, "DuckDuckGo — Privacy, simplified.");
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();;
    }
}
