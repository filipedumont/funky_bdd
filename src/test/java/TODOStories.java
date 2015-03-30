import com.google.common.util.concurrent.MoreExecutors;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.*;
import pages.Pages;
import steps.HomePageSteps;
import steps.TaskSteps;

import java.util.List;

public class TODOStories extends JUnitStories {

    private WebDriverProvider driverProvider = new PropertyWebDriverProvider();
    private WebDriverSteps lifecycleSteps = new PerScenarioWebDriverSteps(driverProvider);
    private Configuration configuration = configuration();
    private SeleniumContext context = new SeleniumContext();
    private ContextView contextView = new LocalFrameContextView().sized(500, 100);

    private Pages pages = new Pages(driverProvider);


    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"),"**/*.story", "**/excluded_*.story");
    }

    @Override
    public Configuration configuration(){
        if (null == configuration){
            Class<? extends Embeddable> embeddableClass = this.getClass();

            return new SeleniumConfiguration()
                    .useSeleniumContext(context)
                    .useWebDriverProvider(driverProvider)
                    .useStepMonitor(new SeleniumStepMonitor(contextView, context, new SilentStepMonitor()))
                    .useStoryLoader(new LoadFromClasspath(embeddableClass))
                    .useStoryReporterBuilder(
                            new StoryReporterBuilder()
                            .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                            .withDefaultFormats()
                            .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML)
                    );
        } else{
            return configuration;
        }
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(
                configuration(),
                new HomePageSteps(pages),
                new TaskSteps(pages),
                lifecycleSteps,
                new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder())
        );
    }

}
