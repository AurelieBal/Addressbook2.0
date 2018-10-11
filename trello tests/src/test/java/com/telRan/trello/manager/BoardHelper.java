package com.telRan.trello.manager;


import com.telRan.trello.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

  public BoardHelper(WebDriver wd) {
    super(wd);
  }

  public void confirmBoardCreation() {
    click(By.cssSelector("button[type=submit]"));
  }

  public void fillBoardForm(Board board) {
    type(By.name("firstname"), board.getTitle());
  }

  public void initContactCreation() {
    click(By.xpath("//a[@href='edit.php']"));
  }

  public void confirmAlert() {
    wd.switchTo().alert().accept();
  }

  public void deleteContact() {
    click(By.cssSelector("[value=Delete]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.cssSelector("[title=Edit]"));
  }

  public void confirmContactModification() {
    click(By.name("update"));  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createBoard() {
    initBoardCreation();
    fillBoardForm(new Board().setTitle("new Board"));
    confirmBoardCreation();
  }

  public void initBoardCreation() {

    click(By.cssSelector("a.js-open-add-menu"));
    click(By.cssSelector("a.js-new-board"));
  }

  public void selectContactByIndex(int i) {
    wd.findElements(By.name("selected[]")).get(i).click();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public int getBoardsCount() {
    return wd.findElements(By.cssSelector("div.content-all-boards")).size();
  }
}
