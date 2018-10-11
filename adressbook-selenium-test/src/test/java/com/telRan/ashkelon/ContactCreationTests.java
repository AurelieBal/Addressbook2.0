package com.telRan.ashkelon;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation(){
        initContactCreation();
        fillContactForm(new ContactData("Debo", "Edery", "Ashkelon", "debo@gmail.com", "0123456789"));
        submitContactCreation();
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        // FirstName

        type(By.name("firstname"), contactData.getfName());
        // LastName

        type(By.name("lastname"), contactData.getlName());

        // Address

        type(By.name("address"), contactData.getAddress());
        // Email

        type(By.name("email"), contactData.getEmail());
        // Phone
        type(By.name("home"), contactData.getPhoneHome());

    }

    public void initContactCreation() {
        click(By.xpath("//a[@href='edit.php']"));
    }
}
