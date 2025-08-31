package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static byte[] captureScreenshot(WebDriver driver, String scenarioName) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destFile = new File(FrameworkConstants.SCREENSHOT_PATH + scenarioName + "_" + timestamp + ".png");

            destFile.getParentFile().mkdirs();
            Files.copy(srcFile.toPath(), destFile.toPath());

            return screenshotBytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
