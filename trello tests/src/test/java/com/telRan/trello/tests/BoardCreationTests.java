package com.telRan.trello.tests;

import com.telRan.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
  @Test
  public  void boardCreationTestUsingButtonPlus(){
    int boardsCountBefore = app.getBoardHelper().getBoardsCount();

    app.getBoardHelper().initBoardCreation();
    app.getBoardHelper().fillBoardForm(new Board().setTitle("new board plus button"));
    app.getBoardHelper().confirmBoardCreation();

   int boardsCountAfter = app.getBoardHelper().getBoardsCount();

    Assert.assertEquals(boardsCountAfter, boardsCountBefore +1);


  }
}
