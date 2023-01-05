package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class CoursesPage extends MainClass { // Страница курсов
    public CoursesPage(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String LOGO_IMG = "//img[@alt ='Онлайн-школа SkillFactory']";
    private static final String CAREER_CENTER_BUTTON = "//a[@class = 'tn-atom' and @href ='/career-center']";
    private static final String PHONE_FORM_BUTTON = "//a[@href='#phoneform']";
    private static final String FORM_INPUT_NAME = "//input[@name = 'name']";
    private static final String PHONE_FORM_SUBMISSION_BUTTON = "//button[@type = 'submit' and text() = 'Отправить']";
    private static final String PHONE_FORM__ERROR_MESSAGE_ITEM = "(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]";
    private static final String LEFT_MENU_PROGRAMMING_BUTTON = "//a[contains(@class, 't-menusub__link-item') and text() = 'Программирование']";
    private static final String SELENIUM_WEBDRIVER_COURSES_BUTTON = "//a[@href = 'https://skillfactory.ru/courses/selenium-webdriver']";
    private static final String JAVA_QA_COURSE_BUTTON = "(//a[@href = 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'])[1]";
    private static final String REGISTRATION_FOR_COURSE_BUTTON = "//div[@data-elem-id = '1596261549401']/a[@class = 'tn-atom' and @href = '#form']";
    private static final String OPTIMUM_TARIFF_SELECTION_BUTTON = "//div[@id='sbs-426327183-1620730172361']/a";
    private static final String REGISTRATION_FORM_INPUT_NAME = "//*[@id='form426327187']//input[@name = 'name']";
    private static final String REGISTRATION_FORM_SUBMISSION_BUTTON = "//*[@id=\"form426327187\"]//button";
    private static final String REGISTRATION_FORM_ERROR_MESSAGE_ITEM = "(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public void returnToTheMainPageByLogoClick() {
        driver.findElement(By.xpath(LOGO_IMG)).click();
    }

    public void goToCareerCenter() {
        driver.findElement(By.xpath(CAREER_CENTER_BUTTON)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public String getValidationMessageFromFormForCallOnCoursesPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_FORM_BUTTON)));
        driver.findElement(By.xpath(PHONE_FORM_BUTTON)).click();
        driver.findElement(By.xpath(FORM_INPUT_NAME)).sendKeys("Алёна");
        driver.findElement(By.xpath(PHONE_FORM_SUBMISSION_BUTTON)).click();
        return driver.findElement(By.xpath(PHONE_FORM__ERROR_MESSAGE_ITEM)).getText();
    }

    public void chooseCourseFromLeftMenu() {
        driver.findElement(By.xpath(LEFT_MENU_PROGRAMMING_BUTTON)).click();
    }

    public void goToCoursesWithSeleniumWebDriverLearning() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELENIUM_WEBDRIVER_COURSES_BUTTON)));
        driver.findElement(By.xpath(SELENIUM_WEBDRIVER_COURSES_BUTTON)).click();
    }

    public String getValidationMessageFromRegistrationFormForCourseQAJava() {
        js.executeScript("window.scrollTo(0,500)");
        driver.findElement(By.xpath(JAVA_QA_COURSE_BUTTON)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath(REGISTRATION_FOR_COURSE_BUTTON)).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(OPTIMUM_TARIFF_SELECTION_BUTTON)))
                .click(driver.findElement(By.xpath(OPTIMUM_TARIFF_SELECTION_BUTTON)));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        driver.findElement(By.xpath(REGISTRATION_FORM_INPUT_NAME)).sendKeys("Алёна");
        driver.findElement(By.xpath(REGISTRATION_FORM_SUBMISSION_BUTTON)).click();
        return driver.findElement(By.xpath(REGISTRATION_FORM_ERROR_MESSAGE_ITEM)).getText();
    }
}
