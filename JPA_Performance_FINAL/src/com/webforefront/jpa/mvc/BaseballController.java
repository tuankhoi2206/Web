package com.webforefront.jpa.mvc;

import java.util.List;
import java.util.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.ModelMap;

import com.webforefront.jpa.domain.Player;
import com.webforefront.jpa.service.PlayerService;


@Controller
public class BaseballController {

    private PlayerService playerService;
  
    @Autowired
    public BaseballController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
	long l1 = System.currentTimeMillis();
	List<Player> hws = playerService.findAll();
	long l2 = System.currentTimeMillis();
	long delta = l2 - l1;
	model.addAttribute("time",delta);
	model.addAttribute("players",hws);
	return "home";
    }

    @RequestMapping(value="/firstname/{firstName}",method = RequestMethod.GET)
    public String byFirstName(ModelMap model, @PathVariable String firstName) {
	long l1 = System.currentTimeMillis();
	List<Player> hws = playerService.findPlayerByFirstName(firstName);
	long l2 = System.currentTimeMillis();
	long delta = l2 - l1;
	model.addAttribute("time",delta);
	model.addAttribute("players",hws);
	model.addAttribute("parameter","First Name");
	model.addAttribute("parametervalue",firstName);
	return "byparameter";
    }


    @RequestMapping(value="/lastname/{lastName}",method = RequestMethod.GET)
    public String byLastName(ModelMap model, @PathVariable String lastName) {
	long l1 = System.currentTimeMillis();
	List<Player> hws = playerService.findPlayerByLastName(lastName);
	long l2 = System.currentTimeMillis();
	long delta = l2 - l1;
	model.addAttribute("time",delta);
	model.addAttribute("players",hws);
	model.addAttribute("parameter","Last Name");
	model.addAttribute("parametervalue",lastName);
	return "byparameter";
    }


    @RequestMapping(value="/playerid/{playerId}",method = RequestMethod.GET)
    public String byPlayerId(ModelMap model, @PathVariable long playerId) {
	long l1 = System.currentTimeMillis();
	Player hw = playerService.findPlayerById(playerId);
	long l2 = System.currentTimeMillis();
	long delta = l2 - l1;
	model.addAttribute("time",delta);
	model.addAttribute("player",hw);
	return "byid";
    }

}
