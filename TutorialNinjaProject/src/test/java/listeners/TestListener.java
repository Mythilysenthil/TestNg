package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ScreenshotUtils;

public class TestListener
implements ITestListener {

    @Override
    public void onTestStart(
            ITestResult result) {

        System.out.println(
                "Test Started: "
                + result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        System.out.println(
                "Test Passed: "
                + result.getName());
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        System.out.println(
                "Test Failed: "
                + result.getName());

        ScreenshotUtils
                .captureScreenshot(
                        result.getName());
    }

    @Override
    public void onStart(
            ITestContext context) {

        System.out.println(
                "Execution Started");
    }

    @Override
    public void onFinish(
            ITestContext context) {

        System.out.println(
                "Execution Completed");
    }
}