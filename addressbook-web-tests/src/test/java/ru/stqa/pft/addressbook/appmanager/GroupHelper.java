package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupPage(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }
  public void fillAddNew(AddNewData addNewData) {
    //type(By.name("theform"), addNewData.getFirstName());
    type(By.name("firstname"), addNewData.getFirstName());
    click(By.name("middlename"));
    type(By.name("lastname"), addNewData.getLastName());
    type(By.name("nickname"), addNewData.getNickName());
    type(By.name("home"), addNewData.getHomePhone());
    type(By.name("mobile"), addNewData.getMobilePhone());
    type(By.name("email"), addNewData.getEmailAdress());}

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
}

