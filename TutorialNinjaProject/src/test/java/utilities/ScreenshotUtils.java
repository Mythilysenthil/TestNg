package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import hooks.Hooks;

public class ScreenshotUtils {

    public static void captureScreenshot(
            String testName) {

        TakesScreenshot ts =
                (TakesScreenshot)
                Hooks.getDriver();

        File source =
                ts.getScreenshotAs(
                        OutputType.FILE);

        String timestamp =
                LocalDateTime.now()
                .format(DateTimeFormatter
                .ofPattern(
                        "yyyyMMdd_HHmmss"));

        File destination =
                new File(
                "screenshots/"
                + testName
                + "_"
                + timestamp
                + ".png");

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println(
                    "Screenshot saved: "
                    + destination.getAbsolutePath());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}