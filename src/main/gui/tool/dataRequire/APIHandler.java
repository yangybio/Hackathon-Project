package gui.tool.dataRequire;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class APIHandler {

    private OverallResult or;

    private String basicURL = "https://lab.isaaclin.cn/nCoV/api/";

    public String getWebData(String urlToUse) throws IOException {
        BufferedReader br = null;
        try {
            String theURL = urlToUse;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } catch (Error e) {
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public OverallResult loadFromDisk() throws IOException {
        String fileDir = "/Users/apple/IdeaProjects/hackathon/TheList.txt";
        BufferedReader br = Files.newBufferedReader(Paths.get(fileDir));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        String str = sb.toString();
        Gson gson = new Gson();
        return gson.fromJson(str, OverallResult.class);
    }

    //EFFECT: return an OverallResult object
    public OverallResult getOverallResult() throws IOException {
        String url = basicURL + "area?latest=0";
        try {
            String content = getWebData(url);
            Gson gson = new Gson();
            return gson.fromJson(content, OverallResult.class);
        } catch (Exception e) {
            or = loadFromDisk();
            return or;
        }
    }

//    public static void main(String[] args) throws IOException {
//        APIHandler apiHandler = new APIHandler();
//        OverallResult or = apiHandler.getOverallResult();
//        for (ProvinceResult pr: or.results) {
//            System.out.println("province: " + pr.provinceName);
//            System.out.println(pr.confirmedCount);
//            System.out.println(pr.deadCount);
//            if (pr.cities != null) {
//                for (CityResult cr: pr.cities) {
//                    System.out.println("city: " + cr.cityName);
//                    System.out.println(cr.confirmedCount);
//                    System.out.println(cr.deadCount);
//                }
//            }
//        }
////        Gson gson = new Gson();
////        OverallResult result = gson.fromJson(content, OverallResult.class);
////        for (DailyResult dr: result.results) {
////            System.out.println("-------------------------");
////            System.out.println("updateTime: " + new Date(dr.updateTime));
////            System.out.println("confirmedCount" + dr.confirmedCount);
////            System.out.println("curedCount" + dr.curedCount);
////            System.out.println("deadCount" + dr.deadCount);
////            System.out.println("suspectedCount" + dr.suspectedCount);
////            System.out.println("-------------------------");
////        }
////        System.out.println(result.results.get(0).updateTime);
//    }


}
