package test;

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

public class MainPageTest extends MainClass { //Главная страница сайта
    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/


    private static final String FREE_EVENTS_BUTTON = "//a[@class = 'tn-atom' and @href='https://skillfactory.ru/free-events']";
  /*  private static final String COURSES_LIST_BUTTON = "";
    private static final String CONTACTS_BUTTON = "//a[@class = 'tn-atom' and @href='/contacts']";
    private static final String CORPORATE_TRAINING_BUTTON = "//a[@class = 'tn-atom'][contains(@href, 'corporativnoye-obuchenye')]";
    private static final String PAGE_LOGO = "//img[@alt ='Онлайн-школа SkillFactory']";
*/
    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    @Test(description = "#1 Переход к странице с курсами по тестированию из хэдера главной страницы")
    public void goToTestingCoursesPage() {
        driver.findElement(By.xpath("(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")));
        driver.findElement(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")).click();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses/testirovanie");
    }

    @Test(description = "#2 Переход к странице \"Бесплатно\" из главной страницы")
    public void goToFreeEventsPage() {
        driver.findElement(By.xpath(FREE_EVENTS_BUTTON)).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Бесплатные\u00A0онлайн-курсы, интенсивы, вебинары и гайды - обучение в SkillFactory");
    }

    @Test(description = "#3 Проверка активности формы для подписки на новости на главной странице")
    public void checkSubscriptionForm() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("(//div[@class='t-input-block']/input[@placeholder = 'E-mail'])[5]")).sendKeys("ghbdtn");
        driver.findElement(By.xpath("//div[@class = 'tn-form__submit']/button[text() = 'Подписаться']")).click();
        String actualMessage = driver.findElement(By.xpath("//p[@class = 't-form__errorbox-item' and text() = 'Укажите, пожалуйста, корректный email']")).getText();
        Assert.assertEquals(actualMessage, "Укажите, пожалуйста, корректный email");
    }

    @Test(description = "#4 Переход к странице 'Корпоративное обучение' из хэдера главной страницы")
    public void goToCorporateTrainingPage() {
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and contains(@href, 'https://new.skillfactory.ru/corporativnoye-obuchenye')]")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Корпоративное обучение от онлайн-школы SkillFactory");
    }

    @Test(description = "#5 Переход к странице 'Сотрудничество' из хэдера главной страницы")
    public void goToPartnershipPage() {
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and contains(@href, 'https://new.skillfactory.ru/partnership')]")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Стать партнером SkillFactory");
    }

    @Test(description = "#6 Переход к странице 'Блог' из хэдера главной страницы")
    public void goToBlogPage() {
        driver.findElement(By.xpath("(//a[@class = 'tn-atom' and contains(@href, 'blog.skillfactory.ru')])[1]")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Блог SkillFactory – Честные истории о карьере в IT из реальной среды");
    }

    @Test(description = "#7 Проверка формы для получения консультации на главной странице")
    public void checkConsultationFormOnMainPage() {
        driver.findElement(By.xpath("//*[@id='form456746058']//input[@aria-label = 'email']")).sendKeys("ghbdtn");
        driver.findElement(By.xpath("//div[@class='tn-form__submit']/button[@type = 'submit' and text() = 'Получить консультацию']")).click();
        String actualMessage = driver.findElement(By.xpath("//div[@id='tilda-popup-for-error']")).getText();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля\n" + "Укажите, пожалуйста, корректный email");
    }

    @Test(description = "#8 Переход к странице со всеми курсами через баннер на главной странице")
    public void goToAllCoursesPage() {
        driver.findElement(By.xpath("(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]")).click();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses");
    }

    @Test(description = "#9 Переход к курсам по Java из футера")
    public void goToJavaCoursesFromFooter() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("//a[@href='https://skillfactory.ru/courses/java']")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Курсы Java: онлайн-обучение языку программирования Java в SkillFactory");
    }

    @Test(description = "#10 Переход к отзывам студентов из футера")
    public void goToStudentsFeedbackFromFooter() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("(//a[@href='/cases-n-reviews'])[2]")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Отзывы студентов о курсах SkillFactory");
    }

    @Test(description = "#11 Переход на Youtube из футера")
    public void goToYoutube() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'tn-atom']/a[text() = 'YouTube']")));
        driver.findElement(By.xpath("//div[@class = 'tn-atom']/a[text() = 'YouTube']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://www.youtube.com/channel/UClOTq6XN8g7-16QLGnZ6_EA");
    }

    @Test(description = "#12 Открытие/закрытие чата с помощником", enabled = false) //Элемент отказывается быть кликабельным
    public void openCarrotquestMessenger() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='carrotquest-messenger-collapsed-img-cont']")));
        driver.findElement(By.xpath("//div[@id='carrotquest-messenger-collapsed-img-cont']")).click();
        // driver.findElement(By.xpath("//button[@class = 'close-button']/div[contains(@class, 'cqi-chat')]")).click();
    }

}
