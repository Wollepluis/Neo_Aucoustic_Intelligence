import Database.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MockupDatabaseTest {

    private MockupDatabase mockupDatabase;
    private DataObject testData;


    @Test
    public void setUp() {
        mockupDatabase = new MockupDatabase();
        this.testData = new UserData();
        this.testData.type = "UserData";
        mockupDatabase.uploadData(testData, testData.type);
    }

    @Test
    public void testUploadData() {
        mockupDatabase = new MockupDatabase();
        this.testData = new UserData();
        this.testData.type = "UserData";
        this.mockupDatabase.uploadData(this.testData, this.testData.type);
        DataObject retrievedData = this.mockupDatabase.getData("1", "UserData");
        assertNotNull(retrievedData);
        assertEquals("1", retrievedData.id);
        assertEquals("UserData", retrievedData.type);
        // Voeg eventuele andere vereiste controles toe voor de opgeslagen data
    }
}
