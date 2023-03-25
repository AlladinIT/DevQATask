package com.example.devqatask;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class MainPageTest {

    private ChromeDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void mainTask() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.playtech.ee");

        WebElement internshipTab = mainPage.internshipTab;
        int getX = internshipTab.getLocation().getX();
        System.out.println("X coordinate: " + getX);
        int getY = internshipTab.getLocation().getY();
        System.out.println("Y coordinate: " + getY);


        Actions actions = new Actions(driver);

        actions.moveByOffset(getX + 1, getY + 1).click().build().perform();

        String s = "Development QA Engineer (Intern)";

        try {
            File myObj = new File("src/test/resources/output.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("src/test/resources/output.txt", true);

            if (driver.getPageSource().contains(s)) {
                myWriter.write("Text \"" + s + "\" is shown on the page. " +
                        "[" +
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) +
                        "]" +
                        "\n");
            } else {
                myWriter.write("Text \"" + s + "\" is not shown on the page. " +
                        "[" +
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) +
                        "]" +
                        "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        driver.close();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
