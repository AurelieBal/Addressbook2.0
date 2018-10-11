package com.telRan.ashkelon;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        openGroupsPage();

        if(!isGroupPresent()){
            createGroup();
        }
    }

    @Test
    public void testGroupModification()
    {
        openGroupsPage();
        selectGroup();
        initNewGroupCreation();
        fillGroupForm(new GroupData("new name","",""));
        confirmGroupModification();
        returnToGroupsPage();
    }

}
