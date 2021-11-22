package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    initGroupCreation();
    app.getGroupHelper().fillGroupPage(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

    app.getNavigationHelper().gotoAddNew();
    app.getGroupHelper().fillAddNew(new AddNewData("Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "Mail@mail.ru", "Anna"));
    app.getGroupHelper().submitAddNew();
    app.getGroupHelper().returnToHomePage();
  }

  private void initGroupCreation() {
    app.getGroupHelper().wd.findElement(By.name("new")).click();
  }

}
