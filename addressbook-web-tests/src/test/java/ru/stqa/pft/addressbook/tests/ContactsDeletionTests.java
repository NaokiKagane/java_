package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.List;

public class ContactsDeletionTests extends TestBase {



  public void ensurePreconditions () {
    if (!app.goToContact().isThereAContact()) {
      app.goTo().gotoAddNew();
      app.goToContact().createContact(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1"));
    }
  }

  @Test
  public void testContactsDeletion () {
    app.goToContact().gotoHomePage();
    List<AddNewData> before = app.goToContact().getContactList();
    int index = before.size() - 1;
    app.goToContact().selectContact(index);
    app.goToContact().deleteSelectedContact();
    app.goToContact().acceptAlert();
    app.goToContact().returnToHomePage();
    List<AddNewData> after = app.goToContact().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
      Assert.assertEquals(before, after);
  }
}
