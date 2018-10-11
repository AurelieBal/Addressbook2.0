package com.telran.repeat.manager;

import com.telran.repeat.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
    }


    public void confirmGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getNameGroup());
        type(By.name("group_header"), group.getHeaderGroup());
        type(By.name("group_footer"), group.getFooterGroup());

    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void updateGroupForm() {
        click(By.name("update"));
    }

    public void editGroup() {
        click(By.name("edit"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    // idem getGroupsCount2

    /**
     * public int getGroupsCount()
     * {
     * return wd.findElements(By.name("selected[]")).size();
     * }
     **/

    public int getGroupsCount2() {
        int count = wd.findElements(By.name("selected[]")).size();
        return count;
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new Group().withFooterGroup("new footer").withHeaderGroup("new header").withNameGroup("new name"));
        confirmGroupCreation();
        returnToGroupsPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));

    }

    public void selectGroupByIndex(int i){
        wd.findElements(By.name("selected[]")).get(i).click();
    }
}
