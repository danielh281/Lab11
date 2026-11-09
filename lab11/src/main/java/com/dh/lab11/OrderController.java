package com.dh.lab11;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author Daniel Haddadeen (2588731)
 */
public class OrderController implements Initializable {


    @FXML
    private MenuItem placeOrderFileBtn;
    @FXML
    private MenuItem clearOrderFileBtn;
    @FXML
    private MenuItem exitFileBtn;
    @FXML
    private MenuItem clearEntreeBtn;
    @FXML
    private MenuItem clearDrinkBtn;
    @FXML
    private MenuItem clearSpecialRequestBtn;
    @FXML
    private MenuItem aboutBtn;
    @FXML
    private ListView<?> entreeListView;
    @FXML
    private RadioButton coffeeRadioBtn;
    @FXML
    private ToggleGroup drinkToggleGroup;
    @FXML
    private RadioButton teaRadioBtn;
    @FXML
    private RadioButton sodaRadioBtn;
    @FXML
    private RadioButton juiceRadioBtn;
    @FXML
    private CheckBox waterCheckBox;
    @FXML
    private TextField specialRequestTextField;
    @FXML
    private Label totalReceiptLabel;
    @FXML
    private Button placeOrderBtn;
    @FXML
    private Button clearOrderBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add menu items
        
    }
    
}
