package io.lhdev.codinggamechallenge.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class LoginPage {

    private WebDriver driver;

    private By accept = By.xpath("//*[text()='Accept']");
    private By emailInputBar = By.cssSelector("input[name=\"email\"]");

    private String email= System.getenv("CODING_GAME_EMAIL");

    private By passwordInputBar= By.cssSelector("input[name=\"password\"]");

    private String password = System.getenv("CODING_GAME_PASSWORD");

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
