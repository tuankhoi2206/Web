package utils;

import javax.servlet.http.HttpServletRequest;

import model.ShoppingCart;

public class ShoppingCartSessionHelper {

	public static final String SHOPPING_CART_SESSION = "myCart";

	public static ShoppingCart getShoppingCartSession(HttpServletRequest req) {

		return (ShoppingCart) req.getSession().getAttribute(
				SHOPPING_CART_SESSION);
	}

}
