package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPS {
    
    private ITekoaly tekoaly;
    
    public KPSTekoaly(ITekoaly tekoaly) {
    	this.tekoaly = tekoaly;
    }

	@Override
	protected String toisenSiirto() {
		String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
	}
}