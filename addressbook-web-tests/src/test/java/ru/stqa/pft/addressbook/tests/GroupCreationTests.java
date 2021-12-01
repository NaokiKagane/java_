package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    initGroupCreation();
    app.getGroupHelper().fillGroupPage(new GroupData("test1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

  }

  private void initGroupCreation() {
    app.getGroupHelper().wd.findElement(By.name("new")).click();
  }

}
