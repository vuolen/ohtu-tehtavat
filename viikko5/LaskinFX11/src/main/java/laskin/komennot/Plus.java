package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Plus implements Komento {

	private TextField tuloskentta;
	private TextField syotekentta;
	private Sovelluslogiikka sovellus;
	private Button nollaa;
	private Button undo;
	
	private String edellinenTulos;
	private String edellinenSyote;

	public Plus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.sovellus = sovellus;
		this.nollaa = nollaa;
		this.undo = undo;
	}
	
	@Override
	public void suorita() {
		this.edellinenTulos = this.tuloskentta.getText();
		this.edellinenSyote = this.syotekentta.getText();
		this.sovellus.plus(Integer.parseInt(syotekentta.getText()));
		this.syotekentta.setText("");
		this.tuloskentta.setText("" + this.sovellus.tulos());
		this.nollaa.disableProperty().set(this.sovellus.tulos() == 0);
		this.undo.disableProperty().set(false);
	}

	@Override
	public void peru() {
		this.syotekentta.setText(edellinenSyote);
		this.tuloskentta.setText(edellinenTulos);
		this.sovellus.miinus(Integer.parseInt(syotekentta.getText()));
		this.undo.disableProperty().set(true);
	}

}
