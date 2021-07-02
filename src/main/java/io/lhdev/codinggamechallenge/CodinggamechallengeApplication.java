package io.lhdev.codinggamechallenge;

import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.lhdev.codinggamechallenge.pages.LoginPage;
import io.lhdev.codinggamechallenge.pages.RankingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("io.lhdev")
public class CodinggamechallengeApplication {

	public static void main(String[] args) throws InterruptedException, IOException {

		SpringApplication.run(CodinggamechallengeApplication.class, args);

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter url: ");
		String URL = myScanner.nextLine();
		System.out.println("Enter new file name: ");
		String fileName = myScanner.nextLine();

		// String URL = "https://www.codingame.com/clashofcode/clash/report/184344691a4dab2e69844a20c0d57f46cf3c885";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(URL);

		LoginPage loginPage = new LoginPage(driver);
		RankingPage rankingPage = new RankingPage(driver);

		// Logging into account first
		WebDriverWait wdw = new WebDriverWait(driver, 20);
		Boolean acceptIsPresent = driver.findElements(By.xpath("//*[text()='Accept']")).size() > 0;
		wdw.until(ExpectedConditions.elementToBeClickable((loginPage.acceptElement())));

		if(acceptIsPresent) {
			loginPage.clickAccept();

			wdw.until(ExpectedConditions.elementToBeClickable(loginPage.loginElement()));
		}


		loginPage.clickLogin();

		wdw.until(ExpectedConditions.elementToBeClickable(loginPage.emailElement()));
		loginPage.typeEmail();
		loginPage.typePassword();
		loginPage.clickLogin2();


		Thread.sleep(2000);
		// Getting player data
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

		// writing results to file setup
		String userHome = System.getProperty("user.home") + "/Desktop";
		File file = new File(userHome, fileName + ".csv");
		boolean fileResult = file.createNewFile();

		if(fileResult) {
			System.out.println("Created new file at " + file.getCanonicalPath());
		} else {
			System.out.println("File already exists at " + file.getCanonicalPath());
		}
		FileOutputStream fs =  new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fs);
		CSVWriter csvWriter = new CSVWriter(osw);

		// writing to file
		csvWriter.writeAll(result);

		// close stream
		csvWriter.close();
		osw.close();
		fs.close();

		driver.quit();
	}

}
