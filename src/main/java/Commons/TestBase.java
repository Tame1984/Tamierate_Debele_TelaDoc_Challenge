package Commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public String getUrl(){
        String URL = "";
        Properties prop = null;
        try {
            prop = readPropertiesFile("src/main/resources/environment.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = (String) prop.get("URL");
        return URL;
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
