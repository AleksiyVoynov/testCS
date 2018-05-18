package Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    MyApplication app = new MyApplication();

    @BeforeSuite
    public void setUp() throws Exception {
        app.common.appStart();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.common.appStop();
    }
}

