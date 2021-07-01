package io.lhdev.codinggamechallenge.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
public class LoginPage {

    private WebDriver driver;

    private By accept = By.xpath("//*[text()='Accept']");
    private By emailInputBar = By.cssSelector("input[name=\"email\"]");

    @Value("${CODING_GAME_EMAIL}")
    private String email = "harrichl@gmail.com";

    private By passwordInputBar= By.cssSelector("input[name=\"password\"]");

    @Value("${CODING_GAME_PASSWORD}")
    private String password = "codingametest1";

    //private By login = By.xpath("//[text()='Log In']");
    private By login = By.xpath("//button[contains(text(),'Log In')]");
    private By login2 = By.cssSelector(("button[type=\"submit\"]"));

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public By acceptElement() {
        return accept;
    }

    public By loginElement() {
        return login;
    }

    public By emailElement() {
        return emailInputBar;
    }

    public void clickAccept() {
        this.driver.findElement(accept).click();
    }

    public void clickLogin() {
        this.driver.findElement(login).click();
    }

    public void typeEmail() {
        this.driver.findElement(emailInputBar).sendKeys(email);;
    }

    public void typePassword() {
        this.driver.findElement(passwordInputBar).sendKeys(password);;
    }

    public void clickLogin2() {
        this.driver.findElement(login2).click();
    }
}
