package Helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class JsonUtils {

    public static void writeInJsonFile(Object javaClass, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(javaClass);
        FileWriter file = new FileWriter(filePath);
        file.write(jsonStr);
        file.close();
    }

    public static <T>T  mapJsonToJavaClass(Class<T> javaClass, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), javaClass);
    }
}
