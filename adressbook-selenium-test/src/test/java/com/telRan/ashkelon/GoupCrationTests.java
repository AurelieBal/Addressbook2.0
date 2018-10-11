package com.telRan.ashkelon;

import org.testng.annotations.Test;

public class GoupCrationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        initNewGroupCreation();
        fillGroupForm(new GroupData("name", "header", "footer"));
        confirmNewGroupCreation();
        returnToGroupsPage();
    }
    @Test
    public void testGroupCreationEmpty() {
        openGroupsPage();
        initNewGroupCreation();
        fillGroupForm(new GroupData("", "", ""));
        confirmNewGroupCreation();
        returnToGroupsPage();
    }

    @Test
    public void testGroupCreationLongName() {
        openGroupsPage();
        initNewGroupCreation();
        fillGroupForm(new GroupData("nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "header", "footer"));
        confirmNewGroupCreation();
        returnToGroupsPage();
    }


}
