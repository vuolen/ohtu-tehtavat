package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.IViitegeneraattori;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements IViitegeneraattori {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
