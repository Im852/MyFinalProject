package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreeEvents extends MainClass { //Страница с бесплатными мероприятиями и материалами
    public FreeEvents(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String REGISTRATION_FORM_BUTTON = "(//*[@id=\"rec487651778\"]//td[text() = 'Зарегистрироваться бесплатно'])[8]";
    private static final String REGISTRATION_FORM_INPUT_EMAIL = "//div[@class ='t-input-block']/input[@placeholder = 'Email']";
    private static final String REGISTRATION_FORM_SUBMISSION_BUTTON = "//*[@id=\"form501376382\"]//button[@class = 't-submit']";
    private static final String REGISTRATION_FORM_ERROR_MESSAGE_ITEM = "(//p[text() = 'Укажите, пожалуйста, корректный email'])[1]";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public String getValidationMessageFromRegistrationFormForFreeIntensives() {
        driver.findElement(By.xpath(REGISTRATION_FORM_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REGISTRATION_FORM_INPUT_EMAIL)));
        driver.findElement(By.xpath(REGISTRATION_FORM_INPUT_EMAIL)).sendKeys("ghbdtn");
        driver.findElement(By.xpath(REGISTRATION_FORM_SUBMISSION_BUTTON)).click();
        return driver.findElement(By.xpath(REGISTRATION_FORM_ERROR_MESSAGE_ITEM)).getText();
    }
}

