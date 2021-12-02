package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    app.getContactHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNew();
      app.getContactHelper().createContact(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1"));
    }
    app.getGroupHelper().initContactModification();
    app.getContactHelper().fillAddNew(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", null),false);
    app.getContactHelper().submitModification();
    app.getContactHelper().returnToHomePage();
  }
}
