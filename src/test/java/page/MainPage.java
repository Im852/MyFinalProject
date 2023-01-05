package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;


public class MainPage extends MainClass { //Главная страница сайта
    public MainPage(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String FREE_EVENTS_BUTTON_IN_HEADER = "//a[@class = 'tn-atom' and @href='https://skillfactory.ru/free-events']";
    private static final String ALL_COURSES_BUTTON_ON_BANNER = "(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]";
    private static final String TESTING_COURSES_BUTTON_ON_COURSES_PAGE = ("//div[@class = 't976__list-item']/a[text() = 'Тестирование']");
    private static final String YOUTUBE_BUTTON_FOOTER = "//div[@class = 'tn-atom']/a[text() = 'YouTube']";
    private static final String STUDENTS_FEEDBACK_BUTTON_FOOTER = "(//a[@href='/cases-n-reviews'])[2]";
    private static final String JAVA_COURSE_BUTTON_FOOTER = "//a[@href='https://skillfactory.ru/courses/java']";
    private static final String EMAIL_FIELD_FOOTER = "(//div[@class='t-input-block']/input[@placeholder = 'E-mail'])[5]";
    private static final String SUBSCRIBE_BUTTON_FOOTER = "//div[@class = 'tn-form__submit']/button[text() = 'Подписаться']";
    private static final String SUBSCRIBE_ERROR_MESSAGE_ITEM = "//p[@class = 't-form__errorbox-item' and text() = 'Укажите, пожалуйста, корректный email']";
    private static final String CORPORATE_TRAINING_BUTTON_IN_HEADER = "//a[@class = 'tn-atom' and contains(@href, 'https://new.skillfactory.ru/corporativnoye-obuchenye')]";
    private static final String BLOG_BUTTON_IN_HEADER = "(//a[@class = 'tn-atom' and contains(@href, 'blog.skillfactory.ru')])[1]";
    private static final String PARTNERSHIP_BUTTON_IN_HEADER = "//a[@class = 'tn-atom' and contains(@href, 'https://new.skillfactory.ru/partnership')]";
    private static final String CONSULTATION_FORM_INPUT_EMAIL = "//*[@id='form456746058']//input[@aria-label = 'email']";
    private static final String CONSULTATION_FORM_GET_CONSULTATION_BUTTON = "//div[@class='tn-form__submit']/button[@type = 'submit' and text() = 'Получить консультацию']";
    private static final String CONSULTATION_FORM_ERROR_MESSAGE_ITEM = "//div[@id='tilda-popup-for-error']";
    private static final String OPEN_MESSENGER_BUTTON = "//div[@id='carrotquest-messenger-collapsed-img-cont']";
    private static final String CLOSE_MESSENGER_BUTTON = "//button[@class = 'close-button']/div[contains(@class, 'cqi-chat')]";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public void goToTestingCoursesPage() {
        driver.findElement(By.xpath(ALL_COURSES_BUTTON_ON_BANNER)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TESTING_COURSES_BUTTON_ON_COURSES_PAGE)));
        driver.findElement(By.xpath(TESTING_COURSES_BUTTON_ON_COURSES_PAGE)).click();
    }

    public void goToFreeEventsPage() {
        driver.findElement(By.xpath(FREE_EVENTS_BUTTON_IN_HEADER)).click();
    }

    public String getSubscriptionValidationMessage() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath(EMAIL_FIELD_FOOTER)).sendKeys("ghbdtn");
        driver.findElement(By.xpath(SUBSCRIBE_BUTTON_FOOTER)).click();
        return driver.findElement(By.xpath(SUBSCRIBE_ERROR_MESSAGE_ITEM)).getText();
    }


    public void goToCorporateTrainingPage() {
        driver.findElement(By.xpath(CORPORATE_TRAINING_BUTTON_IN_HEADER)).click();
    }

    public void goToPartnershipPage() {
        driver.findElement(By.xpath(PARTNERSHIP_BUTTON_IN_HEADER)).click();
    }

    public void goToBlogPage() {
        driver.findElement(By.xpath(BLOG_BUTTON_IN_HEADER)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public String getValidationMessageFromConsultationFormOnMainPage() {
        driver.findElement(By.xpath(CONSULTATION_FORM_INPUT_EMAIL)).sendKeys("ghbdtn");
        driver.findElement(By.xpath(CONSULTATION_FORM_GET_CONSULTATION_BUTTON)).click();
        return driver.findElement(By.xpath(CONSULTATION_FORM_ERROR_MESSAGE_ITEM)).getText();
    }

    public void goToAllCoursesPage() {
        driver.findElement(By.xpath(ALL_COURSES_BUTTON_ON_BANNER)).click();
    }

    public void goToJavaCoursesFromFooter() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath(JAVA_COURSE_BUTTON_FOOTER)).click();
    }

    public void goToStudentsFeedbackFromFooter() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath(STUDENTS_FEEDBACK_BUTTON_FOOTER)).click();
    }

    public void goToYoutube() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(YOUTUBE_BUTTON_FOOTER)));
        driver.findElement(By.xpath(YOUTUBE_BUTTON_FOOTER)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    // Для теста, который у меня так и не получился - элемент 'OPEN_MESSENGER_BUTTON' отказывается быть кликабельным
    public void checkCarrotQuestMessenger() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OPEN_MESSENGER_BUTTON)));
        driver.findElement(By.xpath(OPEN_MESSENGER_BUTTON)).click();
        driver.findElement(By.xpath(CLOSE_MESSENGER_BUTTON)).click();
    }
}
