package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    initGroupCreation();
    app.fillGroupPage(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();

    app.gotoAddNew();
    app.fillAddNew(new AddNewData("Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "Mail@mail.ru", "Anna"));
    app.submitAddNew();
    app.returnToHomePage();
  }

  private void initGroupCreation() {
    app.wd.findElement(By.name("new")).click();
  }

}
