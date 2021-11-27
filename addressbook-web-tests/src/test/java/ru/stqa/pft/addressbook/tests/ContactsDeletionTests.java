package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeletionTests extends TestBase {

  @Test

  public void testContactsDeletion () {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptAllert();
    app.getContactHelper().returnToHomePage();
  }
}
