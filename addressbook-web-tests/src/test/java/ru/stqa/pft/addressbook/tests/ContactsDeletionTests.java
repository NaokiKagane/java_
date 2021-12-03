package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.testng.Assert.*;

public class ContactsDeletionTests extends TestBase {


  @Test
  public void testContactsDeletion () {
    app.goToContact().gotoHomePage();
    Contacts before = app.goToContact().all();
    ensurePreconditions();
    AddNewData deletedContact = before.iterator().next();
    app.goToContact().delete (deletedContact);
    Contacts after = app.goToContact().all();
    assertEquals(after.size(), before.size() - 1);

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));

  }


  public void ensurePreconditions () {
    if (!app.goToContact().isThereAContact()) {
      app.goTo().gotoAddNew();
      app.goToContact().createContact(new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
              withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1"));
    }
  }
}
