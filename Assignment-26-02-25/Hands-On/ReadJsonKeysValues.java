import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class ReadJsonKeysValues {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(new File("data.json"));

        Iterator<String> fieldNames = root.fieldNames();
        while (fieldNames.hasNext()) {
            String field = fieldNames.next();
            System.out.println(field + ": " + root.get(field));
        }
    }
}
