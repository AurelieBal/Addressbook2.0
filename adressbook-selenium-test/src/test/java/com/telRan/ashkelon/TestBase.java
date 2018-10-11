package com.telRan.ashkelon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wd.get("http://localhost/adressbook/");

        login("admin", "secret");


    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);

        click(By.xpath("//*[@type='submit']"));


    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupsPage() {
    click(By.cssSelector("i a"));
    }

    public void confirmNewGroupCreation() {
        click(By.name("submit"));
    }

    protected void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initNewGroupCreation() {
    click(By.name("new"));
    }

    public void openGroupsPage() {
        wd.findElement((By.xpath("//a[@href='group.php']"))).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void confirmGroupModification() {
        click(By.name("update"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void createGroup() {
        initNewGroupCreation();
        fillGroupForm(new GroupData("name", "header", "footer"));
        confirmNewGroupCreation();
        returnToGroupsPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    private boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectGroupeByIndex(int i){
        wd.findElements(By.name("selected[]")).get(i).click();
    }

    public int getGroupsCount(){
        return wd.findElements(By.name("selected[]")).size();
    }
}
