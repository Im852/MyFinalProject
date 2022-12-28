package test;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CareerCanterPageTest extends MainClass { //Страница Карьерный центр

    @Test(description = "#20 Проверка формы 'Задать вопрос центру карьеры' на странице Центра карьеры")
    public void checkQuestionFormOnCareerCenterPage() {
        driver.findElement(By.xpath("//a[@href = '#submenu:details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Все онлайн-курсы']")));
        driver.findElement(By.xpath("//span[text() ='Все онлайн-курсы']")).click();
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and @href ='/career-center']")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//a[@href = 'https://skillfactory.ru/career-center-students']")).click();
        driver.findElement(By.xpath("(//a[@href = '#popup:centr_k_form'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='t-input-block']/input[@name = 'name']")).sendKeys("Алёна");
        driver.findElement(By.xpath("//div[@class = 't-form__submit']/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 't-form__errorbox')])[1]")));
        String actualMessage = driver.findElement(By.xpath("(//div[contains(@class, 't-form__errorbox')])[1]")).getText();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
