package com.telran.repeat.tests;

import com.telran.repeat.model.Contact;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testsContactModification() {
        app.getNavigationHelper().openHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        //app.getContactHelper().fillContactForm(new Contact("Eyal", "Hayou", "Paris", "eyal@telran.com", "2345786"));
        app.getContactHelper().fillContactForm(new Contact()
                .setfName("Eyal")
                .setlName("Hayou")
                .setAddress("Paris")
                .setEmail("moshe@telran.com")
                .setPhone("2345678"));
        app.getContactHelper().confirmContactModification();
    }

}
