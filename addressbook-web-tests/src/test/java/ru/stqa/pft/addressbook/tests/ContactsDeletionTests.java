package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeletionTests extends TestBase {

  @Test

  public void testContactsDeletion () {
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContact();
    app.getGroupHelper().acceptAllert();
    app.getGroupHelper().returnToHomePage();
  }
}
