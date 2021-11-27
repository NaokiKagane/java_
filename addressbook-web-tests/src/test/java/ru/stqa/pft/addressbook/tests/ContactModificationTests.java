package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddNewData;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification () {
    app.getGroupHelper().initContactModification();
    app.getGroupHelper().fillAddNew(new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru"));
    app.getGroupHelper().submitModification();
    app.getGroupHelper().returnToHomePage();
  }
}
