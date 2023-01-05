package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.FreeEvents;
import page.MainPage;

public class FreeEventsTest extends MainClass { //Страница бесплатных материалов и мероприятий

    @Test(description = "#21 Проверка формы регистрации на бесплатные онлайн-интенсивы на странице Бесплатно")
    public void checkRegistrationFormForFreeIntensivesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToFreeEventsPage();
        FreeEvents freeEvents = new FreeEvents(driver);
        String actualMessage = freeEvents.getValidationMessageFromRegistrationFormForFreeIntensives();
        Assert.assertEquals(actualMessage, "Укажите, пожалуйста, корректный email");
    }
}
