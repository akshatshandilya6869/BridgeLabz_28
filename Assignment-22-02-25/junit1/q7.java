import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TaskUtils {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Task Completed";
    }
}

public class TaskUtilsTest extends BasePlatformTestCase {
    private TaskUtils taskUtils;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        taskUtils = new TaskUtils();
    }

    @Test
    @Timeout(2)
    public void testLongRunningTaskTimeout() throws InterruptedException {
        taskUtils.longRunningTask();
    }
}
