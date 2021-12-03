package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    contactPrecondition();
    Set<AddNewData> before = app.goToContact().all();
    AddNewData modifiedContact = before.iterator().next();
    AddNewData contact = new AddNewData ().withid(modifiedContact.getId()).withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
            withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1");
    app.goToContact().modify(contact);
    Set<AddNewData> after = app.goToContact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Comparator<? super AddNewData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId()) ;
    Assert.assertEquals(before, after);

  }

  public void contactPrecondition() {
    app.goToContact().gotoHomePage();
    if (app.goToContact().all().size() == 0) {
      app.goTo().gotoAddNew();
      app.goToContact().createContact(new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
              withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1"));
    }
  }
}
