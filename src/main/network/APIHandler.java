import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;

public class APIHandler {

    private String URL = "https://lab.isaaclin.cn/nCoV/api/overall?latest=0";

    public String getData() throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            String theURL = this.URL;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        APIHandler apiHandler = new APIHandler();
        System.out.println(apiHandler.getData());
    }




}
