package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactCreation () {
    app.goToContact().gotoHomePage();
    Contacts before= app.goToContact().all();
    AddNewData contact = new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
            withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1");
    app.goTo().gotoAddNew();
    app.goToContact().createContact(contact);
    Contacts after = app.goToContact().all();
    assertThat(after.size(), (equalTo(before.size() + 1)));

    assertThat(after, equalTo(
            before.withAdded(contact.withid(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
}
