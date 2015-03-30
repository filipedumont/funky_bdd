package steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import pages.Pages;

/**
 * Created by Filipe on 3/29/2015.
 */
public class HomePageSteps {

    private final Pages pages;

    public HomePageSteps(Pages pages){
        this.pages = pages;
    }

    @Given("user is on $page")
    public void givenUserIsOnPage(String page){
        pages.homePage().navigateToPage();
    }
}
