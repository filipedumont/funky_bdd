package pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

/**
 * Created by Filipe on 3/29/2015.
 */
public class HomePage extends FluentWebDriverPage{// extends AbstractPage {


    public HomePage(WebDriverProvider driverProvider){
        super(driverProvider);
    }

    public void navigateToPage(){
        get("http://rails-todo-demo.herokuapp.com");
    }
}
