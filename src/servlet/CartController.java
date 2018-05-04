package servlet;

import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strAction = request.getParameter("action");

        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("add")) {
                addToCart(request);
            } else if (strAction.equals("Update")) {
                updateCart(request);
            } else if (strAction.equals("Delete")) {
                deleteCart(request);
            }
        }
        response.sendRedirect("../ShoppingCart.jsp");
    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");
        CartService cartService = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartService = (CartService) objCartBean;
        } else {
            cartService = new CartService();
        }
        cartService.deleteCartItem(strItemIndex);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

        CartService cartService = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartService = (CartService) objCartBean;
        } else {
            cartService = new CartService();
        }
        cartService.updateCartItem(strItemIndex, strQuantity);
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strModelNo = request.getParameter("modelNo");
        String strDescription = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");

        CartService cartService = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartService = (CartService) objCartBean;
        } else {
            cartService = new CartService();
            session.setAttribute("cart", cartService);
        }

        cartService.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
    }

}

