package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddNewData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    //click(By.linkText("xpath=//div[2]/input"));
    wd.findElement(By.xpath("//div[2]/input")).click();

  }

  public void submitModification() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddNew(AddNewData addNewData) {
    type(By.name("firstname"), addNewData.getFirstName());
    click(By.name("middlename"));
    type(By.name("lastname"), addNewData.getLastName());
    type(By.name("nickname"), addNewData.getNickName());
    type(By.name("home"), addNewData.getHomePhone());
    type(By.name("mobile"), addNewData.getMobilePhone());
    type(By.name("email"), addNewData.getEmailAdress());
  }

  public void initContactModification() {
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(AddNewData contact) {
    fillAddNew(contact);
    submitAddNew();
    returnToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<AddNewData> getContactList() {
    List<AddNewData> contacts = new ArrayList<AddNewData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr.odd"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      AddNewData contact = new AddNewData("Anna", "Terekhina", "Reoki", "33-33-33", "8-999-999-99-99", "mail@mail.ru", "test1", id);
      contacts.add(contact);
    }
    return contacts;
  }
}

