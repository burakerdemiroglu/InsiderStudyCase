package Case.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"
        },
        glue= {"Case.step_def"},
        features = "src/test/java/Case/features",
        tags = "@positive",
        dryRun = false
)
public class CucumberRunner {

}
