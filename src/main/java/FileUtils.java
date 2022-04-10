import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static String getFilePath(String fileName) {
        var currentPath = Paths.get(System.getProperty("user.dir"));
        var filePath = Paths.get(currentPath.toString(), "src", "main/resources", fileName);
        return filePath.toString();
    }

    public static List<String[]> getDataFromFile(String fileName) throws IOException {

        String line;
        List<String[]> dataList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(FileUtils.getFilePath("InventoryStock.csv")));
        boolean isHeader = true;
        while ((line = br.readLine()) != null) {
            if (isHeader) {
                isHeader = false;
                continue;
            }
            String[] data = line.split(",");
            dataList.add(data);
        }

        return dataList;

    }
}
