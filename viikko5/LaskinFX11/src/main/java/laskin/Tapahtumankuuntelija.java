package laskin;

import java.util.HashMap;
import java.util.Map;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.komennot.Komento;
import laskin.komennot.Miinus;
import laskin.komennot.Nollaa;
import laskin.komennot.Plus;

public class Tapahtumankuuntelija implements EventHandler { 
    private Map<Button, Komento> komennot;
    private Sovelluslogiikka sovellus;
	private Komento edellinen;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Plus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        this.komennot.put(miinus, new Miinus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        this.komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));
    }
    
    @Override
    public void handle(Event event) {
    	 if ( komennot.containsKey(event.getSource()) ) {
             Komento komento = this.komennot.get((Button)event.getTarget());
             komento.suorita();
             this.edellinen = komento;
         } else {
             this.edellinen.peru();
             this.edellinen = null;
         }       
    }

}
