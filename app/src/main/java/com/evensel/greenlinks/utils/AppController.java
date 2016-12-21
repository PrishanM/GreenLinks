package com.evensel.greenlinks.utils;

import com.evensel.greenlinks.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prishan Maduka on 12/20/2016.
 */
public class AppController {

    private static List<Order> orders = new ArrayList<>();

    public static List<Order> getOrders() {
        return orders;
    }

    public static void setOrders(List<Order> orders) {
        AppController.orders = orders;
    }
}
