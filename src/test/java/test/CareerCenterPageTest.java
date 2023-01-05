package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CareerCenterPage;
import page.MainPage;

public class CareerCenterPageTest extends MainClass { //Страница Карьерный центр

    @Test(description = "#20 Проверка формы 'Задать вопрос центру карьеры' на странице Центра карьеры")
    public void checkQuestionFormOnCareerCenterPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        CareerCenterPage careerCenterPage = new CareerCenterPage(driver);
        String actualMessage = careerCenterPage.getValidationMessageFromQuestionFormOnCareerCenterPage();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
