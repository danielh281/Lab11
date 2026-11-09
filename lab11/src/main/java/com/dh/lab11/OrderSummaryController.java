package com.dh.lab11;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Daniel Haddadeen (2588731)
 */
public class OrderSummaryController implements Initializable {

    @FXML
    private Label entreeNameLabel;
    @FXML
    private Label entreePriceLabel;
    @FXML
    private Label drinkNameLabel;
    @FXML
    private Label drinkPriceLabel;
    @FXML
    private Label waterLabel;
    @FXML
    private Label specialRequestLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Button closeBtn;

    private OrderController orderController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionClose(ActionEvent event) throws IOException {
        if (!(orderController.orderSummaryStage == null)) {
            orderController.orderSummaryStage.close();
            orderController.orderSummaryStage = null;
        }
    }
    
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
    
    public void populateOrderSummary() {
        System.out.println(orderController);
        
        String entree = (orderController.entree != null) ? orderController.entree : "";
        double entreePrice = (Config.entreePrices.get(entree) != null) ? Config.entreePrices.get(entree) : 0;
        
        String drink = (orderController.drink != null) ? orderController.drink : "";
        double drinkPrice = (Config.drinkPrices.get(drink) != null) ? Config.drinkPrices.get(drink) : 0;
        
        boolean water = orderController.water;
        
        entreeNameLabel.setText(orderController.entree);
        entreePriceLabel.setText(String.format("$%.2f", entreePrice));
        
        drinkNameLabel.setText(orderController.drink);
        drinkPriceLabel.setText(String.format("$%.2f", drinkPrice));
        
        waterLabel.setText(water ? "Yes" : "No");
        
        totalPriceLabel.setText(String.format("$%.2f", entreePrice + drinkPrice));
    }
}
