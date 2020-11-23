
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            KASVATUSKOKO = 5;
    private int kasvatuskoko;
    private int[] alkiot;
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, KASVATUSKOKO);

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin pitää olla >0");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon pitää olla >0");
        }
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLuku(int luku) {

        if (!kuuluuJoukkoon(luku)) {
        	if (alkioidenLkm == alkiot.length) {
        		kasvataTaulukkoa();
        	}
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }
    
    private void kasvataTaulukkoa() {
    	int[] temp = new int[alkiot.length];
        temp = alkiot;
        alkiot = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(temp, alkiot);
    }

    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poistaLuku(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
            	for (int j = i + 1; j < alkioidenLkm; j++) {
            		alkiot[j-1] = alkiot[j];
            	}
            	alkioidenLkm--;
                break;
            }
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += alkiot[i];
            if (i != alkioidenLkm - 1)
            	tuotos += ", ";
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = alkiot[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaaLuku(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaaLuku(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluuJoukkoon(aTaulu[i])) {
            	y.lisaaLuku(aTaulu[i]);
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
        	if (!b.kuuluuJoukkoon(aTaulu[i])) {
        		z.lisaaLuku(aTaulu[i]);
            }
        }
 
        return z;
    }
        
}
