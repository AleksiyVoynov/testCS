package Tests;

import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class Tests extends BaseTest {

    @Test(description = "find data")
    public void Search() throws FileNotFoundException {
        app.steps.inputSearch("DEVELOPER");
    }

    @Test(dependsOnMethods = {"Search"}, description = "write results in .csv file")
    public void AddResultsToCSV() throws FileNotFoundException {
        app.steps.writeCSVData();
    }

    @Test(dependsOnMethods = {"AddResultsToCSV"}, description = "compare results with exemplar file")
    public void CompareResults() {

    }
}