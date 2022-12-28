package test;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsPageTest extends MainClass { //Страница Контакты
    @Test(description = "#19 Проверка формы 'Задать вопрос' на странице Контакты")
    public void checkQuestionFormFromContactsPage() {
        driver.findElement(By.xpath("(//div[@class = 'tn-atom']/a[@href='https://skillfactory.ru/courses'])[1]")).click();
        driver.findElement(By.xpath("//a[@class = 'tn-atom' and @href = '/contacts']")).click();
        driver.findElement(By.xpath("(//div[@class = 't650__inner-col'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class = 't-input-block']/input[@placeholder = 'Ваше имя'])[1]")));
        driver.findElement(By.xpath(" (//div[@class = 't-input-block']/input[@placeholder = 'Ваше имя'])[1]")).sendKeys("Алёна");
        driver.findElement(By.xpath("(//div[@class = 't-form__submit']/button[text() = 'Отправить'])[1]")).click();
        String actualMessage = driver.findElement(By.xpath("(//p[text() = 'Пожалуйста, заполните все обязательные поля'])[1]")).getText();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
