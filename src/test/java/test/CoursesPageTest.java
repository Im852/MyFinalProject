package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoursesPage;
import page.MainPage;


public class CoursesPageTest extends MainClass { //Страница списка курсов + страницы отдельных курсов

    @Test(description = "#13 Возврат на главную страницу из страницы списка курсов при клике на лого в хэдере")
    public void returnToTheMainPageByLogoClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.returnToTheMainPageByLogoClick();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям");
    }

    @Test(description = "#14 Переход к странице 'Центр карьеры' через страницу списка курсов")
    public void goToCareerCenterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.goToCareerCenter();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Центр карьеры SkillFactory");
    }

    @Test(description = "#15 Проверка формы для заказа звонка на странице списка курсов")
    public void checkFormForCallOnCoursesPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        String actualMessage = coursesPage.getValidationMessageFromFormForCallOnCoursesPage();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }

    @Test(description = "#16 Выбор курсов на странице курсов через левое меню")
    public void chooseCourseFromLeftMenuTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToTestingCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.chooseCourseFromLeftMenu();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://skillfactory.ru/courses/programmirovanie");
    }

    @Test(description = "#17 Переход к курсам по тестированию, на которых изучается Selenium WebDriver из главной страницы")
    public void goToCoursesWithSeleniumWebDriverLearningTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToTestingCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.goToCoursesWithSeleniumWebDriverLearning();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Курсы Selenium WebDriver по тестированию web-приложений");
    }

    @Test(description = "#18 Проверка формы для записи на курс 'QA-инженер на Java'")
    //Тест, который дался сложнее всего, иногда может падать
    public void checkRegistrationFormForCourseQAJavaTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToTestingCoursesPage();
        CoursesPage coursesPage = new CoursesPage(driver);
        String actualMessage = coursesPage.getValidationMessageFromRegistrationFormForCourseQAJava();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
