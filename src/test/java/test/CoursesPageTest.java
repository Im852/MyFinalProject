package test;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CoursesPageTest extends MainClass { //Страница списка курсов + страницы отдельных курсов
    @Test(description = "#13 Возврат на главную страницу из страницы списка курсов при клике на лого в хэдере")
    public void returnToTheMainPageByLogoClick() {
        driver.findElement(By.xpath("//a[@href = '#submenu:details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Все онлайн-курсы']")));
        driver.findElement(By.xpath("//span[text() ='Все онлайн-курсы']")).click();
        driver.findElement(By.xpath("//img[@alt ='Онлайн-школа SkillFactory']")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям");
    }

    @Test(description = "#14 Переход к странице 'Центр карьеры' из главной страницы через страницу списка курсов")
    public void goToCareerCenter() {
        driver.findElement(By.xpath("//a[@href = '#submenu:details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Все онлайн-курсы']")));
        driver.findElement(By.xpath("//span[text() ='Все онлайн-курсы']")).click();
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and @href ='/career-center']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Центр карьеры SkillFactory");
    }

    @Test(description = "#15 Проверка формы для заказа звонка на странице списка курсов")
    public void checkFormForCallOnCoursesPage() {
        driver.findElement(By.xpath("//a[@href = '#submenu:details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Все онлайн-курсы']")));
        driver.findElement(By.xpath("//span[text() ='Все онлайн-курсы']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#phoneform']")));
        driver.findElement(By.xpath("//a[@href='#phoneform']")).click();
        driver.findElement(By.xpath("//input[@name = 'name']")).sendKeys("Алёна");
        driver.findElement(By.xpath("//button[@type = 'submit' and text() = 'Отправить']")).click();
        String actualMessage = driver.findElement(By.xpath("(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]")).getText();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }

    @Test(description = "#16 Использование левого меню для выбора тематики курсов на странице курсов")
    public void chooseCourseFromLeftMenu() {
        driver.findElement(By.xpath("(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")));
        driver.findElement(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")).click();
        driver.findElement(By.xpath("//a[contains(@class, 't-menusub__link-item') and text() = 'Программирование']")).click();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses/programmirovanie");
    }

    @Test(description = "#17 Переход к курсам по тестированию, на которых изучается Selenium WebDriver из главной страницы")
    public void goToCoursesWithSeleniumWebDriverLearning() {
        driver.findElement(By.xpath("(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")));
        driver.findElement(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href = 'https://skillfactory.ru/courses/selenium-webdriver']")));
        driver.findElement(By.xpath("//a[@href = 'https://skillfactory.ru/courses/selenium-webdriver']")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Курсы Selenium WebDriver по тестированию web-приложений");
    }

    @Test(description = "#18 Проверка формы для записи на курс 'QA-инженер на Java'")
    //Тест, который дался сложнее всего
    public void checkRegistrationFormForCourseQAJava() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'tn-atom' and text() = 'Подробнее']")));
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and text() = 'Подробнее']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")));
        driver.findElement(By.xpath("//div[@class = 't976__list-item']/a[text() = 'Тестирование']")).click();
        js.executeScript("window.scrollTo(0,500)");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href = 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'])[2]")));
        driver.findElement(By.xpath("(//a[@href = 'https://skillfactory.ru/java-qa-engineer-testirovshik-po'])[1]")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//div[@data-elem-id = '1596261549401']/a[@class = 'tn-atom' and @href = '#form']")).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='sbs-426327183-1620730172361']/a")))
                .click(driver.findElement(By.xpath("//div[@id='sbs-426327183-1620730172361']/a")));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        driver.findElement(By.xpath("//*[@id='form426327187']//input[@name = 'name']")).sendKeys("Алёна");
        driver.findElement(By.xpath("//*[@id=\"form426327187\"]//button")).click();
        String actualMessage = driver.findElement(By.xpath("(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]")).getText();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
