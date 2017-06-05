package controller;

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
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Accounts;
import utils.ViewConstants;
import validator.LoginValidator;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("loginValidator")
	private LoginValidator loginValidator;

	@InitBinder(value = { "/login" })
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(this.loginValidator);
	}

	private final String ACCOUNT_ATTRIBUTE = "account";

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLoginPage(Model uiModel) {
		uiModel.addAttribute(ACCOUNT_ATTRIBUTE, new Accounts("TuanKhoi", true, "test", "f"));
		return ViewConstants.LINK_LOGIN_VIEW;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginPage(Model uiModel, @Validated @ModelAttribute("account") Accounts accounts,
			BindingResult result) {

		if (result.hasErrors()) {
			uiModel.addAttribute(accounts);
			return ViewConstants.LINK_LOGIN_VIEW;
		}

		return ViewConstants.LINK_ACCOUNT_INFOR_VIEW;
	}
}
