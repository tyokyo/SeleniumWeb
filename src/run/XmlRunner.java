package run;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;
import org.uncommons.reportng.JUnitXMLReporter;
import listener.TestngListener;

public class XmlRunner {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void main(String[] args) throws Exception {
		System.setProperty(ESCAPE_PROPERTY, "false"); 
		// TODO Auto-generated method stub
		TestNgXml.startMakeReport();
		
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		testNG.addListener(new TestngListener());
		//testNG.addListener(new OSFilter());
		//testNG.addListener(new IProgressTracker());
		//testNG.setThreadCount(2);
		
		//testNG.setSuiteThreadPoolSize(2);
		testNG.setOutputDirectory(TestNgXml.reportFolder);
		List<String> suits = new ArrayList<String>();
		suits.add("xml/DiscoverCase.xml");
		testNG.setTestSuites(suits);
		testNG.run();
		System.out.println(testNG.getOutputDirectory());
		//copy report
		TestNgXml.endMakeReport();
	}
}

