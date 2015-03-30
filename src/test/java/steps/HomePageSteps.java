package steps;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.assertTrue;
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
    @Alias("I am on $page")
    public void givenUserIsOnPage(String page){
        if("HomePage".equals(page))
            pages.homePage().navigateToPage();
    }

    @When("user authenticates on system with $username and $password")
    //@Composite(steps = { "When user clicks on $link in $page"
   // })
    public void userAuthenticatesOnSystem(String username, String password) {
        pages.homePage().signInWith(username, password);
    }

    @When("user clicks on $link in $page")
    public void userClicksOnLinkInPage(String link, String page){
        if("HomePage".equals(page))
            pages.homePage().clicksOn(link);
        else if("TaskPage".equals(page))
            pages.taskPage().clicksOn(link);
    }

    @Then("user should be on $page")
    public void userShouldBeOnPage(String page){
        if("HomePage".equals(page)){
            assertTrue(pages.homePage().verifyPage());
        }
        else if("TaskPage".equals(page)){
           assertTrue(pages.taskPage().verifyPage());
        }
    }
}
