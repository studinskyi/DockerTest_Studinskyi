package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RemoteDriverManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();

    }

    public void open() {
        String pageSiteName = "http://soft.it-hillel.com.ua:8080/login.jsp";
        driver.get(pageSiteName);
        //driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");

        // ожидание после открытия страницы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("opening the page of login by path: " + pageSiteName + " *" + getCurrenDateTimeString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Enter user name")
    public void enterUsername() {
        driver.findElement(By.xpath("//input[@id='login-form-username']")).sendKeys("studinskyi");
        //driver.findElement(By.id("login-form-username")).sendKeys("studinskyi");
    }

    @Step("Enter user password")
    public void enterPassword() {
        driver.findElement(By.xpath("//input[@id='login-form-password']")).sendKeys("dima_st)");
        //driver.findElement(By.id("login-form-password2")).sendKeys("dima_st)");
    }

    @Step("Click login")
    public void clickLogin() {
        driver.findElement(By.xpath("//input[@id='login-form-submit']")).click();
        //driver.findElement(By.id("login-form-submit")).click();
    }

    public String getCurrenDateTimeString() {
        Date d = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return formatDate.format(d);
    }


}
