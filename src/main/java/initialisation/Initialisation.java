package initialisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Initialisation {

    Properties properties;

    public WebDriver initialise(){
        propertyFileReader();
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            //chrome driver
            System.setProperty("webdriver.chrome.driver", "//Users//seema//Documents//DroneShield//src//test//resources//drivers//chromedriver-mac-x64//chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            return driver;
        }

        else if(browserName.equals("safari")){
            //chrome driver
            System.setProperty("webdriver.safari.driver", "//Users//seema//Downloads//safariDriver");
            WebDriver driver = new SafariDriver(); //instantiating the driver
            return driver;
        }

        else {
            return null;
        }

    }

    public void propertyFileReader() {
         properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/seema/Documents/DroneShield/src/test/resources/TestData.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }
