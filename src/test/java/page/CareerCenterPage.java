package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class CareerCenterPage extends MainClass { //Страница карьерного центра
    public CareerCenterPage(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String CAREER_CENTER_BUTTON_IN_HEADER = "//a[@class = 'tn-atom' and @href ='/career-center']";
    private static final String STUDENTS_BUTTON = "//a[@href = 'https://skillfactory.ru/career-center-students']";
    private static final String QUESTION_FORM_BUTTON = "(//a[@href = '#popup:centr_k_form'])[1]";
    private static final String QUESTION_FORM_INPUT_NAME = "//div[@class='t-input-block']/input[@name = 'name']";
    private static final String QUESTION_FORM_SUBMISSION_BUTTON = "//div[@class = 't-form__submit']/button";
    private static final String QUESTION_FORM_ERROR_MESSAGE_ITEM = "(//div[contains(@class, 't-form__errorbox')])[1]";
    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public String getValidationMessageFromQuestionFormOnCareerCenterPage() {
        driver.findElement(By.xpath(CAREER_CENTER_BUTTON_IN_HEADER)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath(STUDENTS_BUTTON)).click();
        driver.findElement(By.xpath(QUESTION_FORM_BUTTON)).click();
        driver.findElement(By.xpath(QUESTION_FORM_INPUT_NAME)).sendKeys("Алёна");
        driver.findElement(By.xpath(QUESTION_FORM_SUBMISSION_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUESTION_FORM_ERROR_MESSAGE_ITEM)));
        return driver.findElement(By.xpath(QUESTION_FORM_ERROR_MESSAGE_ITEM)).getText();
    }
}
