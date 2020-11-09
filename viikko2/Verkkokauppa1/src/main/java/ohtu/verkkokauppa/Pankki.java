package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.IPankki;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements IPankki {

    private Kirjanpito kirjanpito;

    public Pankki(Kirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
