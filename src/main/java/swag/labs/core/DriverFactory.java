package swag.labs.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DriverFactory {
    public static AppiumDriver createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Samsung A56");
        options.setUdid("RFCY60EXHQK");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity(".SplashActivity");
        options.setCapability("appium:skipDeviceInitialization", false);
        options.setCapability("appium:skipServerInstallation", true);

        return new AppiumDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options
        );
    }
}
