package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.BaseTest;

import utilities.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    private static final Logger log =LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        log.info("Test Started: "+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        log.info("Test Passed: "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("Test Failed: "+ result.getName());

        ScreenshotUtil.takeScreenshot(BaseTest.getDriver(),result.getName());

        log.info("Screenshot captured");
    }

    @Override
    public void onStart(ITestContext context) {

        log.info("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        log.info("Execution Finished");
    }
}