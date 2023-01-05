package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class MainPageTest extends MainClass { //Главная страница сайта

    @Test(description = "#1 Переход к странице с курсами по тестированию из хэдера главной страницы")
    public void goToTestingCoursesPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToTestingCoursesPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses/testirovanie");
    }

    @Test(description = "#2 Переход к странице \"Бесплатно\" из главной страницы")
    public void goToFreeEventsPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToFreeEventsPage();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Бесплатные\u00A0онлайн-курсы, интенсивы, вебинары и гайды - обучение в SkillFactory");
    }

    @Test(description = "#3 Проверка активности формы для подписки на новости на главной странице")
    public void checkSubscriptionFormTest() {
        MainPage mainPage = new MainPage(driver);
        String actualMessage = mainPage.getSubscriptionValidationMessage();
        Assert.assertEquals(actualMessage, "Укажите, пожалуйста, корректный email");
    }

    @Test(description = "#4 Переход к странице 'Корпоративное обучение' из хэдера главной страницы")
    public void goToCorporateTrainingPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToCorporateTrainingPage();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Корпоративное обучение от онлайн-школы SkillFactory");
    }

    @Test(description = "#5 Переход к странице 'Сотрудничество' из хэдера главной страницы")
    public void goToPartnershipPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPartnershipPage();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Стать партнером SkillFactory");
    }

    @Test(description = "#6 Переход к странице 'Блог' из хэдера главной страницы")
    public void goToBlogPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToBlogPage();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Блог SkillFactory – Честные истории о карьере в IT из реальной среды");
    }

    @Test(description = "#7 Проверка формы для получения консультации на главной странице")
    public void checkConsultationFormOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        String actualMessage = mainPage.getValidationMessageFromConsultationFormOnMainPage();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля\n" + "Укажите, пожалуйста, корректный email");
    }

    @Test(description = "#8 Переход к странице со всеми курсами через баннер на главной странице")
    public void goToAllCoursesPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses");
    }

    @Test(description = "#9 Переход к курсам по Java из футера")
    public void goToJavaCoursesFromFooterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToJavaCoursesFromFooter();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Курсы Java: онлайн-обучение языку программирования Java в SkillFactory");
    }

    @Test(description = "#10 Переход к отзывам студентов из футера")
    public void goToStudentsFeedbackFromFooterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToStudentsFeedbackFromFooter();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Отзывы студентов о курсах SkillFactory");
    }

    @Test(description = "#11 Переход на Youtube из футера")
    public void goToYoutubeTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToYoutube();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://www.youtube.com/channel/UClOTq6XN8g7-16QLGnZ6_EA");
    }

    @Test(description = "#12 Открытие/закрытие чата с помощником", enabled = false)
    //Элемент отказывается быть кликабельным, интересно было бы узнать, в чём моя ошибка
    public void openCarrotQuestMessengerTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.checkCarrotQuestMessenger();
    }

}
