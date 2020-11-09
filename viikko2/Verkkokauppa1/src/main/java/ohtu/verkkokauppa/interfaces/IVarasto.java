/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa.interfaces;

import java.util.HashMap;
import ohtu.verkkokauppa.Tuote;

/**
 *
 * @author Lennu Vuolanne <vuolanne.lennu@gmail.com>
 */
public interface IVarasto {
            
    public Tuote haeTuote(int id);

    public int saldo(int id);
    
    public void otaVarastosta(Tuote t);
    
    public void palautaVarastoon(Tuote t);
    
}
