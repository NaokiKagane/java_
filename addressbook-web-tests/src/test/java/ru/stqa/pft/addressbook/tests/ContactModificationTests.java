package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.testng.Assert.*;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    contactPrecondition();
    Contacts before = app.goToContact().all();
    AddNewData modifiedContact = before.iterator().next();
    AddNewData contact = new AddNewData ().withid(modifiedContact.getId()).withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
            withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1");
    app.goToContact().modify(contact);
    Contacts after = app.goToContact().all();
    assertEquals(after.size(), before.size());

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(
            before.without(modifiedContact).withAdded(contact)));
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
