package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber -> TestNg , junit
@CucumberOptions(features="src/test/java/cucumber",glue="rahulsheetyacademy/stepDefinition",monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests
{
  
}
