package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupPage(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"),groupData.getHeader());
    type(By.name("group_footer"),groupData.getFooter());
  }


  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModfication() {
    click(By.name("update"));
  }
  public void returnToHomePage() {
    click(By.linkText("home"));
  }
  public void submitAddNew() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
  public void gotoHomePage() {
      click(By.linkText("home"));
  }

  public void selectContact() {
    //click(By.linkText("selected[16]"));
    wd.findElement(By.id("MassCB")).click();;
  }

  public void deleteSelectedContact() {
    //click(By.linkText("xpath=//div[2]/input"));
    wd.findElement(By.xpath("//div[2]/input")).click();

  }

  public void acceptAllert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
  }

  public void submitModification() {
    wd.findElement(By.xpath("//input[22]")).click();
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupPage(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}

