package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.function.Function;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.TAB;

public class MainPage extends MainClass { //Главная страница сайта
    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/


    private static final String FREE_EVENTS_BUTTON = "//a[@class = 'tn-atom' and @href='https://skillfactory.ru/free-events']";
    private static final String COURSES_LIST_BUTTON = "";
    private static final String CONTACTS_BUTTON = "//a[@class = 'tn-atom' and @href='/contacts']";
    private static final String CORPORATE_TRAINING_BUTTON = "//a[@class = 'tn-atom'][contains(@href, 'corporativnoye-obuchenye')]";
    private static final String PAGE_LOGO = "//img[@alt ='Онлайн-школа SkillFactory']";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/
}