package dad.javafx.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class Controlador implements Initializable {

	Modelo modelo = new Modelo();
	
	@FXML
	GridPane view;

	public Controlador() throws IOException {
		FXMLLoader cargador = new FXMLLoader(getClass().getResource("Vista.fxml"));
		cargador.setController(this);
		cargador.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public Modelo getModelo() {
		return modelo;
	}

	public GridPane getView() {
		return view;
	}
}
