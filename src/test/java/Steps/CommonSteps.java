package Steps;


import Pages.BasePage;

public class CommonSteps extends BasePage {

    public void appStop() {
        driver.quit();
    }

    public void appStart(){
        driver.get(BaseURL);
    }

}
