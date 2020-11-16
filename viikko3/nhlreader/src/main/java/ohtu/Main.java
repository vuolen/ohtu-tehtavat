package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players, new Comparator<Player>() {
                public int compare(Player p1, Player p2) {
                    return Integer.compare(p2.getGoals() + p2.getAssists(), p1.getGoals() + p1.getAssists());
                }
        });
        System.out.println("Oliot:");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }   
    }
  
}
