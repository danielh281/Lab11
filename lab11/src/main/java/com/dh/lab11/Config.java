package com.dh.lab11;

import java.util.Map;
/**
 *
 * @author Daniel Haddadeen (2588731)
 */
public class Config {
    public static final String[] menuItems = {
        "Chicken Salad", "Turkey Sandwich", "Vegetable Wrap", "Grilled Cheese"
    };
    
    public static final Map<String, Double> entreePrices = Map.of(
            "Chicken Salad", 6.50,
            "Turkey Sandwich", 6.75,
            "Vegetable Wrap", 6.00,
            "Grilled Cheese", 5.00
    );
    
    public static final Map<String, Double> drinkPrices = Map.of(
            "Coffee", 1.50,
            "Tea", 1.50,
            "Soda", 2.00,
            "Juice", 1.75
    );
}
