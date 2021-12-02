package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddNewData;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
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
    //click(By.id("25"));
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteSelectedContact() {
    //click(By.linkText("xpath=//div[2]/input"));
    wd.findElement(By.xpath("//div[2]/input")).click();

  }

  public void submitModification() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddNew(AddNewData addNewData, boolean creation) {
    type(By.name("firstname"), addNewData.getFirstName());
    click(By.name("middlename"));
    type(By.name("lastname"), addNewData.getLastName());
    type(By.name("nickname"), addNewData.getNickName());
    type(By.name("home"), addNewData.getHomePhone());
    type(By.name("mobile"), addNewData.getMobilePhone());
    type(By.name("email"), addNewData.getEmailAdress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addNewData.getGroup());
    } else {
    Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void acceptAlert () {
      wd.switchTo().alert().accept();
    }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(AddNewData contact) {
    fillAddNew(contact, true);
    submitAddNew();
    returnToHomePage();
  }
}
