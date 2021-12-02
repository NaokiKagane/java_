package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.List;

public class ContactsDeletionTests extends TestBase {

  @Test

  public void testContactsDeletion () {
    app.getContactHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNew();
      app.getContactHelper().createContact(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1"));
    }
    List<AddNewData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptAlert();
    app.getContactHelper().returnToHomePage();
    List<AddNewData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }
}
