package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactCreation () {
    app.getContactHelper().gotoHomePage();
    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().createContact(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1"));
  }
}
