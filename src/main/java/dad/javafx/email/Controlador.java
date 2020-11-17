package dad.javafx.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Controlador implements Initializable {

	private Modelo modelo = new Modelo();
	
	@FXML
	private GridPane view;
	
	@FXML
    private TextArea textMensaje;

    @FXML
    private Button botonVaciar;

    @FXML
    private Button botonCerrar;

    @FXML
    private TextField tfPuerto;

    @FXML
    private TextField tfSmtp;

    @FXML
    private TextField tfRemitente;

    @FXML
    private Button botonEnviar;

    @FXML
    private PasswordField pfContrasenia;

    @FXML
    private TextField tfDestinatario;

    @FXML
    private TextField tfAsunto;

    @FXML
    private CheckBox cbSSL;
    
    
    private Alert alerta;

	public Controlador() throws IOException {
		FXMLLoader cargador = new FXMLLoader(getClass().getResource("Vista.fxml"));
		cargador.setController(this);
		cargador.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		modelo.valorSmtpProperty().bindBidirectional(tfSmtp.textProperty());
		modelo.valorPuertoProperty().bindBidirectional(tfPuerto.textProperty());
		modelo.valorRemitenteProperty().bindBidirectional(tfRemitente.textProperty());
		modelo.valorContraseniaProperty().bindBidirectional(pfContrasenia.textProperty());
		modelo.valorDestinatarioProperty().bindBidirectional(tfDestinatario.textProperty());
		modelo.valorAsuntoProperty().bindBidirectional(tfAsunto.textProperty());
		modelo.valorMensajeProperty().bindBidirectional(textMensaje.textProperty());
		
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public GridPane getView() {
		return view;
	}
	
	@FXML
    void cerrar(ActionEvent event) {
		Stage stage = (Stage) botonCerrar.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void enviar(ActionEvent event) {

    	try
    	{
    		int puerto = Integer.parseInt(tfPuerto.getText());
    		
    		if(cbSSL.selectedProperty().get() == false)
    		{
    			alerta = new Alert(AlertType.WARNING);
        		alerta.setTitle("Información");
        		alerta.setHeaderText("No se ha marcado la casilla de conexión SSL");
    		}
    	}
    	catch(Exception e)
    	{
    		alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error");
    		alerta.setHeaderText("No se pudo enviar el email");
    		alerta.setContentText(e.getMessage());
    	}
    }

    @FXML
    void vaciar(ActionEvent event) {

    	modelo.setValorAsunto("");
    	modelo.setValorContrasenia("");
    	modelo.setValorDestinatario("");
    	modelo.setValorMensaje("");
    	modelo.setValorPuerto("");
    	modelo.setValorRemitente("");
    	modelo.setValorSmtp("");
    	cbSSL.selectedProperty().set(false);
    }
}
