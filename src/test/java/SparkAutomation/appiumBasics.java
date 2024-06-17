package SparkAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class appiumBasics {
public AppiumDriverLocalService service;
    @Test
    public void androidTest() throws MalformedURLException, URISyntaxException {
        service=new AppiumServiceBuilder().withAppiumJS(new File("//Users//kalyanin//.nvm//versions//node//v16.19.1//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5 API 31");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");


        //emulator
        options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//ApiDemos-debug.apk");



        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();


    }

}

