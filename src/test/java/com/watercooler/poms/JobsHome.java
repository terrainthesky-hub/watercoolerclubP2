package com.watercooler.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JobsHome {

    private WebDriver driver;

    private By companyCreateButton = By.id("company");
    private By companyLoginButton = By.id("companySignin");
    private By userCreateButton = By.id("user");
    private By userLoginButton = By.id("userSignin");

    private By selectUn = By.id("username");
    private By selectPw = By.id("password");
    private By login = By.id("login");

    public JobsHome(WebDriver driver){
        this.driver = driver;
        // the page factory abstracts away the logic for interacting with web elements
        PageFactory.initElements(driver,this);
    }



    public void sendKeysToUserLogin(String input){
        driver.findElement(selectUn).sendKeys(input);
    }

    public void sendKeysToUserPassword(String input){driver.findElement(selectPw).sendKeys(input);}

    public void clickCompanyCreateButton(){ driver.findElement(companyCreateButton).click(); }

    public void clickCompanyLoginButton(){
        driver.findElement(companyLoginButton).click();
    }

    public void clickUserCreateButton(){ driver.findElement(userCreateButton).click(); }

    public void clickUserLoginButton() { driver.findElement(userLoginButton).click(); }

    public void clickLoginButton() { driver.findElement(login).click(); }


    }
