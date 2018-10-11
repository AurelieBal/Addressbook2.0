package com.telRan.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper  extends HelperBase {
  public SessionHelper(WebDriver wd) {
    super(wd);
  }
  public void login(String user, String password) {
    click(By.xpath("//a[@href='/login?returnUrl=%2F']"));
    // click(By.cssSelector("[href='/'login?returnUrl=%2F']"));
    type(By.name("user"), user);
    type(By.name("password"), password);
    click(By.id("login"));
  }
}
