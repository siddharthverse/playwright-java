package siddharth;

import com.microsoft.playwright.Page;

public class AllPages {
    private Page page;
    private String searchIcon = "#search";

    public AllPages(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        String title = page.title();
        System.out.println(title);
        return title;
    }

    public String getPageURL() {
        String url = page.url();
        System.out.println(url);
        return url;
        // 43:04
    }
}
