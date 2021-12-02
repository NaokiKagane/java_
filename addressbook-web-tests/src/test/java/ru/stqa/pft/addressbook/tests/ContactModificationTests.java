package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    app.getContactHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNew();
      app.getContactHelper().createContact(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1"));
    }
    List<AddNewData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    AddNewData contact = new AddNewData ( "Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", null);
    app.getContactHelper().fillAddNew (contact);
    app.getContactHelper().submitModification();
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().gotoHomePage();
    List<AddNewData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super AddNewData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
