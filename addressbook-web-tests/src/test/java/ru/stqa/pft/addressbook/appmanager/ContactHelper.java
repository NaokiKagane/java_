package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.AddNewData;

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
      contacts.add(new AddNewData().withFirstName("Anna").withLastName("Terekhina").withNickName("Reoki").
              withHomePhone("33-33-33").withMobilePhone("8-999-999-99-99").withEmailAdress("mail@mail.ru").withGroup("test1").withid(id));
    }
    return contacts;
  }
  public void fillContact() {
    gotoHomePage();
    initContactModification();
  AddNewData contact = new AddNewData ();
    fillAddNew (contact);
    submitModification();
    returnToHomePage();
  }
}


