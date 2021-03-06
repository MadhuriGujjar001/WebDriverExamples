package Test.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Moreno on 07/02/2016.
 */
public class ScreenShot{

    static public void takeScreenShot(String fileName, WebDriver driver) throws IOException {
        synchronized (driver) {
            fileName += "_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());

            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshot, new File("./Screenshots/" + fileName + ".png"));
        }
    }
}
