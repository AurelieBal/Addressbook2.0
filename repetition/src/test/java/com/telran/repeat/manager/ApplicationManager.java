package com.telran.repeat.manager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private  String browser;
    WebDriver wd;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {

        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }
        else if(browser.equals(BrowserType.FIREFOX))
        {
            wd = new FirefoxDriver();
        }
        else if(browser.equals(BrowserType.SAFARI))
        {
            wd = new SafariDriver();
        }
        
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook/");

        sessionHelper = new SessionHelper(wd);
        //login

        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }


    public void stop() {
        wd.quit();
    }


    public void returnToHomePage() {
        groupHelper.click(By.xpath("//a[@href=./]"));
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;


    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

}
