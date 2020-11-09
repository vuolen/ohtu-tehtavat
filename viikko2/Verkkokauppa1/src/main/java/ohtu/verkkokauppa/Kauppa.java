package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.IVarasto;
import ohtu.verkkokauppa.interfaces.IPankki;
import ohtu.verkkokauppa.interfaces.IViitegeneraattori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    @Autowired
    private IVarasto varasto;
    @Autowired
    private IPankki pankki;
    private Ostoskori ostoskori;
    @Autowired
    private IViitegeneraattori viitegeneraattori;
    private String kaupanTili = "33333-44455";

    public void aloitaAsiointi() {
        this.ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
