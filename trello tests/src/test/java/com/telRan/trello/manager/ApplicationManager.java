package com.telRan.trello.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private SessionHelper sessionHelper;
  //private GroupHelper groupHelper;
  private BoardHelper boardHelper;
  private ListHelper listHelper;
  private NavigationHelper navigationHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void start() {
   if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper = new NavigationHelper(wd);
    navigationHelper.openSite("https://trello.com/");

    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("edery.deborah@gmail.com", "Mikou999");


//    groupHelper = new GroupHelper(wd);
   boardHelper = new BoardHelper(wd);
   listHelper = new ListHelper(wd);

  }



  public void stop() {
    wd.quit();
  }

  //__________________________________________________________________


  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

//  public GroupHelper getGroupHelper() {
//    return groupHelper;
//  }
//
  public BoardHelper getBoardHelper() {
    return boardHelper;
  }

  public ListHelper getListHelper() {
    return listHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
