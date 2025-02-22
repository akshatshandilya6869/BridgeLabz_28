import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import java.util.*;

class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }
    
    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }
    
    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest extends BasePlatformTestCase {
    private ListManager listManager;
    private List<Integer> testList;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        listManager = new ListManager();
        testList = new ArrayList<>();
    }
    
    public void testAddElement() {
        listManager.addElement(testList, 5);
        assertTrue(testList.contains(5));
    }
    
    public void testRemoveElement() {
        testList.add(5);
        listManager.removeElement(testList, 5);
        assertFalse(testList.contains(5));
    }
    
    public void testGetSize() {
        listManager.addElement(testList, 5);
        listManager.addElement(testList, 10);
        assertEquals(2, listManager.getSize(testList));
    }
}
