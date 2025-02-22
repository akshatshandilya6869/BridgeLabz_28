import com.intellij.testFramework.fixtures.BasePlatformTestCase;

class DatabaseConnection {
    private boolean isConnected;

    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return isConnected;
    }
}

public class DatabaseConnectionTest extends BasePlatformTestCase {
    private DatabaseConnection dbConnection;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @Override
    protected void tearDown() throws Exception {
        dbConnection.disconnect();
        super.tearDown();
    }

    public void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }

    public void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected());
    }
}
