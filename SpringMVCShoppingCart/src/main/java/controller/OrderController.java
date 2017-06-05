package controller;

import javax.servlet.http.HttpServletRequest;

import model.Customer;
import model.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.ShoppingCartSessionHelper;
import utils.ViewConstants;
import validator.ShoppingCartCustomerValidator;

@Controller
public class OrderController {
	@Autowired
	@Qualifier("cartCustomerValidator")
	private ShoppingCartCustomerValidator cartCustomerValidator;

	@InitBinder("updateOrder")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(this.cartCustomerValidator);
	}

	/*
	 * page :myCart. Interface BindingResult: Stores and exposes information
	 * about data-binding and validation errors for a specific object.
	 * 
	 * When Spring binding data it will be inital target object.
	 */
	@RequestMapping(value = { "/updateOrder" })
	public String updateOrder(Model model,
			@Validated @ModelAttribute("customer") Customer custor,
			BindingResult resul, HttpServletRequest req) {
		/*
		 * Có lỗi chuyển lại về trang shoppingCartCustomer. Ngược lại chuyển về
		 * trang shoppingCartConfirmation
		 */

		// Có lỗi
		if (resul.hasErrors()) {
			model.addAttribute("customer", custor);
			return ViewConstants.LINK_SHOPPING_CART_CUSTOMER_VIEW;
		}
		ShoppingCart sessCart = ShoppingCartSessionHelper
				.getShoppingCartSession(req);

		if (sessCart == null || sessCart.getSumItem() < 1) {
			return "redirect:/productList";
		}
		sessCart.setCustomer(custor);
		model.addAttribute("shoppingCart", sessCart);
		return ViewConstants.LINK_SHOPPING_CART_CONFIRMATION_VIEW;
	}
}
