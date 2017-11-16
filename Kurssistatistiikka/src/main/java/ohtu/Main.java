package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "123456";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
        String infoUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String infoBodyText = Request.Get(infoUrl).execute().returnContent().asString();
        System.out.println(infoBodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Info info = mapper.fromJson(infoBodyText, Info.class);
                
        int totalExercises = 0;
        int totalHours = 0;
        
        System.out.println("opiskelijanumero: "+studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.println(submission);
            totalExercises += submission.getExercisesCount();
            totalHours += submission.getHours();
        }
        System.out.println("");
        System.out.println("Yhteensa: "+totalExercises+" tehtavaa "+totalHours+" tuntia");
    }
}