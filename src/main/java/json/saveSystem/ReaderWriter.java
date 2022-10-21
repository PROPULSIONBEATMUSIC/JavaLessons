package json.saveSystem;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReaderWriter {

    public static void mapper() throws IOException {
        System.out.println("\nMapper");
        String path = "src/main/resources/save.json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        SaveSystem system = new SaveSystem(1, 100, 10000, 13, 23, 44, 80, 54, 65, 34);
        objectMapper.writeValue(new File(String.valueOf(new File(path))), system);


        String jsn = objectMapper.writeValueAsString(system);
        System.out.println(jsn);

        String jsonArray = "{\"day\":0,\"manpower\":5,\"budget\":100,\"pollution\":87,\"rep_gov\":0,\"rep_civ\":1,\"rep_wrk\":2,\"rep_sci\":3,\"rep_fag\":4,\"rep_bus\":5}";
        Map<String, Object> map = objectMapper.readValue(jsonArray, new TypeReference<Map<String, Object>>(){});
        System.out.println("\nMap: " + map);

        System.out.println("\nTree");
        JsonNode jsonNode = objectMapper.readTree(new File(String.valueOf(new File(path))));
        String money = jsonNode.get("budget").asText();
        String manPower = jsonNode.get("manpower").asText();
        String pollution = jsonNode.get("pollution").asText();
        System.out.println(
                "Money: " + money
                        + "\nManPower: " + manPower
                        + "\nPollution: " + pollution);
    }

}
