package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
         mutableCapabilities.setCapability("browserstack.user", "yuryloskutov_UXEbj4");
         mutableCapabilities.setCapability("browserstack.key", "ubE8mo15cbM13oqAUCQm");

         // Set URL of the application under test
         mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

         // Specify device and os_version for testing
         mutableCapabilities.setCapability("device", "Google Pixel 3");
         mutableCapabilities.setCapability("os_version", "9.0");

         // Set other BrowserStack capabilities
         mutableCapabilities.setCapability("project", "QA.GURU lesson 12/21");
         mutableCapabilities.setCapability("build", "browserstack-build-1");
         mutableCapabilities.setCapability("name", "selenide android test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    private URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
