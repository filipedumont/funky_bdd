package pages;

import org.jbehave.web.selenium.WebDriverProvider;

/**
 * Created by Filipe on 3/29/2015.
 */
public class Pages {

    private HomePage homePage;
    private final WebDriverProvider driverProvider;

    public Pages(WebDriverProvider driverProvider){
        this.driverProvider = driverProvider;
    }

    public HomePage homePage(){
        if(null == homePage){
            homePage = new HomePage(driverProvider);
        }
        return homePage;
    }
}
