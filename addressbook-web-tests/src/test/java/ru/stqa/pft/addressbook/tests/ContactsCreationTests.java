package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

import java.util.Comparator;
import java.util.List;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactCreation () {
    app.goToContact().gotoHomePage();
    List<AddNewData> before = app.goToContact().getContactList();
    AddNewData contact = new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
            withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1");
    app.goTo().gotoAddNew();
    app.goToContact().createContact(contact);
    List<AddNewData> after = app.goToContact().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super AddNewData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
