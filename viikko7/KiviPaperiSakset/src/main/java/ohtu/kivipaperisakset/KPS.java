package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPS {

	private static final Scanner scanner = new Scanner(System.in);

	public void pelaa() {
		Tuomari tuomari = new Tuomari();
		
		String ekanSiirto = ensimmaisenSiirto();
		String tokanSiirto = toisenSiirto();
		while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
			tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
			System.out.println(tuomari);
			System.out.println();

			ekanSiirto = ensimmaisenSiirto();
			tokanSiirto = toisenSiirto();
		}

		System.out.println();
		System.out.println("Kiitos!");
		System.out.println(tuomari);
	}
	
	private String ensimmaisenSiirto() {
    	System.out.println("Ensimmäisen pelaajan siirto: ");
    	return scanner.nextLine();
    }
	
	abstract protected String toisenSiirto();

	private static boolean onkoOkSiirto(String siirto) {
		return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
	}
	
	public static KPS luoPelaajaPeli() {
		return new KPSPelaajaVsPelaaja();
	}
	
	public static KPS luoTekoalyPeli() {
		return new KPSTekoaly(new Tekoaly());
	}
	
	public static KPS luoParempiTekoalyPeli() {
		return new KPSTekoaly(new TekoalyParannettu(20));
	}
}
