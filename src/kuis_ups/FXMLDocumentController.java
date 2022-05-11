package kuis_ups;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import kuis_ups.db.DBHandler;
import kuis_ups.model.UPS;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnSimpan;


    @FXML
    private DatePicker dpTanggalBeli;

    @FXML
    private TextField tfMerk;
    
    @FXML
    private ToggleGroup warna;

    @FXML
    private RadioButton rdHitam;

    @FXML
    private RadioButton rdPutih;

    @FXML
    private TextField kode;
    
    @FXML
    private TextField tfHarga;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(kode.getText());
        System.out.println(tfMerk.getText());
        System.out.println(dpTanggalBeli.getValue().toString());
        String warna ="";
        if(rdHitam.isSelected())
            warna = rdHitam.getText();
        if(rdPutih.isSelected())
            warna = rdPutih.getText();
        System.out.println(warna);
        System.out.println(tfHarga.getText());
        
        UPS u = new UPS(kode.getText(),tfMerk.getText(),dpTanggalBeli.getValue().toString(),
        warna, tfHarga.getText());
        
        DBHandler dh = new DBHandler("MYSQL");
        dh.addUPS(u);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }       
    
}
