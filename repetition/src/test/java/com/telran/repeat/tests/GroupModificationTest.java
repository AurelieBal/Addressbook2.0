package com.telran.repeat.tests;

import com.telran.repeat.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
    }
    @Test
    public void testGroupModification() {

        app.getNavigationHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount2();

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new Group()
                .withNameGroup("new name")
                .withHeaderGroup("new header")
                .withFooterGroup("new footer"));
        app.getGroupHelper().updateGroupForm();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount2();

        Assert.assertEquals(before, after);


    }

    @Test
    public void testEmptyGroupModification() {
        app.getNavigationHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount2();

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new Group().withNameGroup("").withHeaderGroup("").withFooterGroup(""));
        app.getContactHelper().confirmContactModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupsCount2();

        Assert.assertEquals(after, before);


    }

}
