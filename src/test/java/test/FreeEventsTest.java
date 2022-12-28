package test;

import base.MainClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreeEventsTest extends MainClass { //Страница бесплатных материалов и мероприятий

    @Test(description = "#21 Проверка формы регистрации на бесплатные онлайн-интенсивы на странице Бесплатно")
    public void checkRegistrationFormForFreeIntensives() {
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and @href='https://skillfactory.ru/free-events']")).click();
        driver.findElement(By.xpath("(//*[@id=\"rec487651778\"]//td[text() = 'Зарегистрироваться бесплатно'])[4]")).click();
        driver.findElement(By.xpath("//div[@class ='t-input-block']/input[@placeholder = 'Email']")).sendKeys("ghbdtn");
        driver.findElement(By.xpath("//*[@id=\"form501376382\"]//button[@class = 't-submit']")).click();
        String actualMessage = driver.findElement(By.xpath("(//p[text() = 'Укажите, пожалуйста, корректный email'])[1]")).getText();
        Assert.assertEquals(actualMessage, "Укажите, пожалуйста, корректный email");
    }
}
