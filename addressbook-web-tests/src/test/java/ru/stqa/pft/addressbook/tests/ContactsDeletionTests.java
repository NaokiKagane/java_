package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactsDeletionTests extends TestBase {


  @Test
  public void testContactsDeletion () {
    app.goToContact().gotoHomePage();
    Set<AddNewData> before = app.goToContact().all();
    ensurePreconditions();
    AddNewData deletedContact = before.iterator().next();
    app.goToContact().delete (deletedContact);
    Set<AddNewData> after = app.goToContact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
      Assert.assertEquals(before, after);

  }


  public void ensurePreconditions () {
    if (!app.goToContact().isThereAContact()) {
      app.goTo().gotoAddNew();
      app.goToContact().createContact(new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
              withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1"));
    }
  }
}
