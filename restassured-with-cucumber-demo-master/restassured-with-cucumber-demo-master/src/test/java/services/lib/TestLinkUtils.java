package services.lib;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


/**
 * Created by garth.combrinck on 2017/06/02.
 * https://github.com/kinow/testlink-java-api/tree/master/src/test/java/br/eti/kinoshita/testlinkjavaapi
 */
public class TestLinkUtils extends TestLinkAPIException {
    private final static String ACCESS_KEY = "7883f74761842243276add891144917a";
    private final static String TESTLINK_SERVER_URL = "http://apollo/testlink-1.9.7/lib/api/xmlrpc/v1/xmlrpc.php";
    private final static String TESTLINK_PROJECT_NAME = "Test Project";
    private final static String TESTLINK_TESTPLAN_NAME = "garth";
    private final static String BUILD_RELEASE_NAME = "Test build";
    private String testCaseExternalID;
    private String description;

    private static TestLinkAPI connect() throws MalformedURLException {
        URL url = new URL(TESTLINK_SERVER_URL);
        return new TestLinkAPI(url, ACCESS_KEY);
    }

    public void setResult(ExecutionStatus status) throws MalformedURLException {
        TestCase testcase = connect().getTestCaseByExternalId(testCaseExternalID, 1);
        TestPlan testPlan = connect().getTestPlanByName(TESTLINK_TESTPLAN_NAME, TESTLINK_PROJECT_NAME);
        int testPlanID = testPlan.getId();
        int testCaseId = testcase.getId();
        ReportTCResultResponse response = connect().setTestCaseExecutionResult(testCaseId, null, testPlanID, status,
                null, BUILD_RELEASE_NAME, description, true, null, null, null, null, true);
    }

    protected void setTestCaseId(String id) {
        this.testCaseExternalID = id;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTestCaseExternalID() {
        return testCaseExternalID;
    }
}
