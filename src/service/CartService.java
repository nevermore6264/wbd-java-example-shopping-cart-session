package service;

import model.Cart;

import java.util.ArrayList;

public class CartService {

    private ArrayList<Cart> listCart = new ArrayList();
    private double dblOrderTotal;

    public int getLineItemCount() {
        return listCart.size();
    }

    public void deleteCartItem(String strItemIndex) {
        int iItemIndex = 0;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            listCart.remove(iItemIndex - 1);
            calculateOrderTotal();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void updateCartItem(String strItemIndex, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        int iItemIndex = 0;
        Cart cartItem = null;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                cartItem = (Cart) listCart.get(iItemIndex - 1);
                dblUnitCost = cartItem.getUnitCost();
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    public void addCartItem(String strModelNo, String strDescription,
                            String strUnitCost, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        Cart cartItem = new Cart();
        try {
            dblUnitCost = Double.parseDouble(strUnitCost);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setPartNumber(strModelNo);
                cartItem.setModelDescription(strDescription);
                cartItem.setUnitCost(dblUnitCost);
                cartItem.setQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                listCart.add(cartItem);
                calculateOrderTotal();
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void addCartItem(Cart cartItem) {
        listCart.add(cartItem);
    }

    public Cart getCartItem(int iItemIndex) {
        Cart cartItem = null;
        if (listCart.size() > iItemIndex) {
            cartItem = (Cart) listCart.get(iItemIndex);
        }
        return cartItem;
    }

    public ArrayList getCartItems() {
        return listCart;
    }

    public void setCartItems(ArrayList alCartItems) {
        this.listCart = alCartItems;
    }

    public double getOrderTotal() {
        return dblOrderTotal;
    }

    public void setOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }

    protected void calculateOrderTotal() {
        double dblTotal = 0;
        for (int counter = 0; counter < listCart.size(); counter++) {
            Cart cartItem = (Cart) listCart.get(counter);
            dblTotal += cartItem.getTotalCost();
        }
        setOrderTotal(dblTotal);
    }
}