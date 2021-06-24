package io.lhdev.codinggamechallenge.configuration;

import lombok.AllArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
public class SeleniumConfiguration {

    @PostConstruct
    void postConstruct(){
        System.setProperty("webdriver.chrome.driver", "/Volumes/SamsungT7/Documents/projects/codinggamechallenge/src/main/resources/chromedriver 5");
    }

    @Bean
    public ChromeDriver driver() {
        return new ChromeDriver();
    }
}
