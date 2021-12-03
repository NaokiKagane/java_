package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    app.goToContact().gotoHomePage();
    contactPrecondition();
    List<AddNewData> before = app.goToContact().getContactList();
    app.goToContact().gotoHomePage();
    app.goToContact().initContactModification();
    AddNewData contact = new AddNewData ();
    app.goToContact().fillAddNew (contact);
    app.goToContact().submitModification();
    app.goToContact().returnToHomePage();
    app.goToContact().gotoHomePage();
    List<AddNewData> after = app.goToContact().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super AddNewData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

  public void contactPrecondition() {
    if (! app.goToContact().isThereAContact()) {
      app.goTo().gotoAddNew();
      app.goToContact().createContact(new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
              withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1"));
    }
  }
}
