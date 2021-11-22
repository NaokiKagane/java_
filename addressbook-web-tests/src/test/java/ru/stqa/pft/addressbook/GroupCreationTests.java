package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;


public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupPage(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();

    gotoAddNew();
    fillAddNew(new AddNewData("Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "Mail@mail.ru", "Anna"));
    submitAddNew();
    returnToHomePage();
  }

  private void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

}
