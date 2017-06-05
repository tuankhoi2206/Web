package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Item;
import model.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ProductService;
import entity.Products;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/home" })
	public String homePage() {
		return "home";
	}

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/productList" })
	public ModelAndView productPage() {
		List<Products> lstProduct = productService.listProduct();
		ModelAndView mv = new ModelAndView("productList");
		mv.addObject("lstProduct", lstProduct);
		return mv;
	}

	// buyProduct?code=S001
	// @RequestMapping(value = { "/buyProduct?code={id}" })
	@RequestMapping(value = { "/buyProduct" })
	public ModelAndView buyProduct(@RequestParam("code") String id, HttpServletRequest req, HttpServletResponse res) {

		Products products = productService.findById(id);
		ShoppingCart cart = null;
		if (products != null) {
			Item item = new Item(products);
			cart = (ShoppingCart) req.getSession().getAttribute("myCart");
			if (cart == null) {

				cart = new ShoppingCart();
				cart.addItem(item);
				req.getSession().setAttribute("myCart", cart);
			} else {
				if (!cart.isExistItem(item)) {
					cart.addItem(item);
				}
			}
		} // end Product

		ModelAndView mv = new ModelAndView("myCart");
		mv.addObject("myCart", cart);
		return mv;
		// return "redirect:/myCart";
	}

	@RequestMapping(value = { "/updateCart" }, method = RequestMethod.POST)
	public ModelAndView updateCart(@ModelAttribute("myCart") ShoppingCart myCart, HttpServletRequest req) {

		ShoppingCart supCart = myCart;
		ShoppingCart sessCart = (ShoppingCart) req.getSession().getAttribute("myCart");

		for (Item item : supCart.getListItem()) {
			sessCart.editItem(item);
		}

		ModelAndView view = new ModelAndView("myCart");
		view.addObject("cart", myCart);
		return view;
	}

	@RequestMapping(value = { "/myCart" })
	public String postMyCart(@ModelAttribute("myCart") ShoppingCart cart, Model model) {
		return "home";
	}

	/*
	 * request shoppingCartCustomer
	 */
	@RequestMapping(value = { "/shoppingCartCustomer" })
	public ModelAndView shoppingCartCustomer() {
		ModelAndView mv = new ModelAndView("shoppingCartCustomer", "customer", new Customer());
		return mv;
	}
}
