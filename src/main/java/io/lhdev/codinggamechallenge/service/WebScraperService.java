package io.lhdev.codinggamechallenge.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.lhdev.codinggamechallenge.pages.RankingPage;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WebScraperService {

    public static void main(String[] args){

        String URL = "https://www.codingame.com/clashofcode/clash/report/18251894f20e9cffc2c6aa10ec90ed55570dea0";

        RankingPage rankingPage = new RankingPage();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        boolean viewCode = false;
        List<String[]> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int id = i + 1;
            if (rankingPage.getViewCode(i) > 0){
                viewCode = true;
            } else {
                viewCode = false;
            }

            String[] playerData = { String.valueOf(id), rankingPage.getNickNameText(i), rankingPage.getScoreText(i),
                    rankingPage.getDurationText(i), String.valueOf(viewCode)};

            result.add(playerData);
            System.out.println(result);
        }
         driver.quit();
        }
    }

