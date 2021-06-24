package io.lhdev.codinggamechallenge.pages;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

@AllArgsConstructor
@NoArgsConstructor
public class RankingPage {

    private ChromeDriver driver;

    private final By playerReport = By.className("player-report");
    private final By nickname = By.className("nickname");
    private final By score = By.xpath("//span[contains(text(), '%')]");
    private final By duration = By.xpath("//*[contains(text(), '00:')]");
    private final By viewCode = By.cssSelector("[ng-if=\"isSolutionVisible(player)\"]");


    public String getNickNameText(int i) {
        return this.driver.findElements(nickname).get(i).getText();
    }

    public String getScoreText(int i ) {
        return this.driver.findElements(score).get(i).getText();
    }

    public String getDurationText(int i) {
        return this.driver.findElements(duration).get(i).getText();
    }

    public int getViewCode(int i) {
        return this.driver.findElements(playerReport).get(i).findElements(viewCode).size();
    }

}
