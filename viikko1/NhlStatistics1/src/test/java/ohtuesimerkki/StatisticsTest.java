package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void playerNamedSemenkoExists() {
       assertNotNull(stats.search("Semenko"));
    }

    @Test
    public void playerNamedAsdDoesntExist() {
        assertNull(stats.search("Asd"));
    }

    @Test
    public void teamNamedAsdIsEmpty() {
        assertEquals(stats.team("Asd").size(), 0);
    }

    @Test
    public void teamNamedEDMIsNotEmpty() {
        assertNotEquals(stats.team("EDM").size(), 0);
    }

    @Test
    public void topScorerIsGretzky() {
        assertEquals(stats.topScorers(1).get(0).getName(), "Gretzky");
    }
}

