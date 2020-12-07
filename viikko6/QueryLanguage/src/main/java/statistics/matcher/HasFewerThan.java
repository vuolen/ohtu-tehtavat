
package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    
	Matcher matcher;

    public HasFewerThan(int value, String category) {
        this.matcher = new Not(new HasAtLeast(value, category));
    }

    @Override
    public boolean matches(Player p) {      
        return this.matcher.matches(p);
    }    
    
}
