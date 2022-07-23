package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browser = BrowserStackMobileDriver.class.getName();
        Configuration.browserSize = null;

    }

    @BeforeEach
    public void startDriver() {


    }

}
