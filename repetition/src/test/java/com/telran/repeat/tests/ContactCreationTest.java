package com.telran.repeat.tests;

import com.telran.repeat.model.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(!app.getContactHelper().isOnTheHomePage()){
            app.getNavigationHelper().openHomePage();
        }

    }

    @Test
    public void createContactTest() {
        app.getContactHelper().initContactCreation();

        //app.getContactHelper().fillContactForm(new Contact("Moshe", "Cohen", "Tel-Aviv", "moshe@telran.com", "0123456789"));

        app.getContactHelper().fillContactForm(new Contact()
                .setfName("Moshe")
                .setlName("Cohen")
                .setAddress("Tel-Aviv")
                .setEmail("moshe@telran.com")
                .setPhone("0123456789"));
        app.getContactHelper().confirmContactCreation();


    }

}
