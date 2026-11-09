package com.dh.lab11;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
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
    private ListView<String> entreeListView;
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
    
    private RadioButton[] drinkRadioButtons;
    
    protected String entree;
    protected String drink;
    protected boolean water;
    protected String specialRequest;
    protected Stage orderSummaryStage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add menu items
        ObservableList<String> menuItems = FXCollections.observableArrayList(Config.menuItems);
        entreeListView.setItems(menuItems);
        
        // Cache drink radio buttons & initialize them;
        drinkRadioButtons = new RadioButton[] {coffeeRadioBtn, teaRadioBtn, sodaRadioBtn, juiceRadioBtn};
        
        for (RadioButton drinkRadioButton : drinkRadioButtons) {
            drinkRadioButton.setUserData(drinkRadioButton.getText());
        }
        
        drinkToggleGroup.selectedToggleProperty().addListener((ov) -> {
            drink = (String) drinkToggleGroup.getSelectedToggle().getUserData();
        });
        
        // Listen for entree selection
        entreeListView.getSelectionModel().selectedItemProperty().addListener((ov) -> {
            entree = entreeListView.getSelectionModel().getSelectedItem();
        });
        
        // Listen for water checkbox
        waterCheckBox.selectedProperty().addListener((ov) -> {
            water = waterCheckBox.isSelected();
        });
    }
    
    @FXML
    private void onActionPlaceOrder(ActionEvent event) throws IOException {
        // If there is already an order summary, don't open another one
        if (!(orderSummaryStage == null)) {
            return;
        }
        
        // Load FXMl for OrderSummary
        FXMLLoader orderSummaryLoader = App.getFXMLLoader("orderSummary");
        Parent root = orderSummaryLoader.load();
        
        // Give OrderSummaryController access to OrderController
        OrderSummaryController orderSummaryController = orderSummaryLoader.getController();
        orderSummaryController.setOrderController(this);
        orderSummaryController.populateOrderSummary();
        
        Scene orderSummaryScene = new Scene(root);
        
        orderSummaryStage = new Stage();
        
        orderSummaryStage.setOnCloseRequest(eh -> {
            orderSummaryStage = null;
        });
        
        orderSummaryStage.setScene(orderSummaryScene);
        orderSummaryStage.setTitle("Order Summary");
        orderSummaryStage.showAndWait();
    }

    @FXML
    private void onActionClearOrder(ActionEvent event) {
        clearEntree(event);
        clearDrink(event);
        clearSpecialRequest(event);
        waterCheckBox.setSelected(false);
    }

    @FXML
    private void onActionExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void clearEntree(ActionEvent event) {
        entreeListView.getSelectionModel().clearSelection();
    }

    @FXML
    private void clearDrink(ActionEvent event) {
        for (RadioButton drinkRadioButton : drinkRadioButtons) {
            drinkRadioButton.setSelected(false);
        }
    }

    @FXML
    private void clearSpecialRequest(ActionEvent event) {
        specialRequestTextField.clear();
    }

    @FXML
    private void onActionAbout(ActionEvent event) {
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
        aboutDialog.setTitle("Available Menu Items & Prices");
        aboutDialog.show();
    }
}
