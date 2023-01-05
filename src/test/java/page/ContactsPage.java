package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends MainClass { // Страница контактов
    public ContactsPage(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String CONTACTS_BUTTON_IN_HEADER = "//a[@class = 'tn-atom' and @href = '/contacts']";
    private static final String QUESTION_FORM_BUTTON = "(//div[@class = 't650__inner-col'])[1]";
    private static final String QUESTION_FORM_INPUT_NAME = "(//div[@class = 't-input-block']/input[@placeholder = 'Ваше имя'])[1]";
    private static final String QUESTION_FORM_SENDING_BUTTON = "(//div[@class = 't-form__submit']/button[text() = 'Отправить'])[1]";
    private static final String QUESTION_FORM_ERROR_MESSAGE_ITEM = "(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public String getValidationMessageFromQuestionForm() {
        driver.findElement(By.xpath(CONTACTS_BUTTON_IN_HEADER)).click();
        driver.findElement(By.xpath(QUESTION_FORM_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUESTION_FORM_INPUT_NAME)));
        driver.findElement(By.xpath(QUESTION_FORM_INPUT_NAME)).sendKeys("Алёна");
        driver.findElement(By.xpath(QUESTION_FORM_SENDING_BUTTON)).click();
        return driver.findElement(By.xpath(QUESTION_FORM_ERROR_MESSAGE_ITEM)).getText();
    }
}
