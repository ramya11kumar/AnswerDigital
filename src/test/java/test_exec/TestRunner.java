package test_exec;


import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/test_exec/DemoQATools.feature"},
        glue= {"test_exec"},
        tags= "@register"
        
        /*
         Tags used in feature file - change tags in line 15 to run appropriate tests
         @register
         @alert
         @hoverbutton
         @draganddrop
         @smallmodal
         @datepicker
         */
)
@RunWith(Cucumber.class)
public class TestRunner extends AbstractTestNGCucumberTests
{
	
}
