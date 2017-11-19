package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "123456";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
        String infoUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String statsUrl = "https://studies.cs.helsinki.fi/ohtustats/stats";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String infoBodyText = Request.Get(infoUrl).execute().returnContent().asString();
        String statsResponse = Request.Get(statsUrl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Info info = mapper.fromJson(infoBodyText, Info.class);
        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
               
        int totalExercises = 0;
        int totalHours = 0;
        int totalRet = 0;
        int totalRetExe = 0;
        
        System.out.println("Kurssi: "+info.getName()+", "+info.getTerm());
        System.out.println("");
        System.out.println("opiskelijanumero: "+studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            int i = submission.getWeek();
            System.out.println("Viikko: " + submission.getWeek());
            submission.setExemax(info.getExercises()[i-1]);
            System.out.println(submission);
            totalExercises += submission.getExercisesCount();
            totalHours += submission.getHours();
            JsonObject parsittu2 = parsittuData.getAsJsonObject(i+"");
            totalRet += parsittu2.get("students").getAsInt();
            totalRetExe += parsittu2.get("exercise_total").getAsInt();
        }
        System.out.println("");
        System.out.println("Yhteensa: "+totalExercises+" tehtavaa "+totalHours+" tuntia");
        System.out.println("");
        System.out.println("Kurssilla yhteensa " + totalRet + " palautusta, palautettuja tehtavia " + totalRetExe + " kpl");
    }
}