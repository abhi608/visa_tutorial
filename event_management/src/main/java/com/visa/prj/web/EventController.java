package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Event;
import com.visa.prj.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService service;
	
	@RequestMapping("eventForm.do")
	public String getEventForm(Model model) { //variant of ModelAndView
		model.addAttribute("event", new Event(0, "EVENT NAME", new Date(), "Bangalore"));
		return "eventform.jsp";
	}
	
	@RequestMapping("addEvent.do")
	public String addEvent(@ModelAttribute("event") Event e) {
		service.addEevent(e);
		return "redirect:index.jsp"; // redirect is needed to redirect | if redirect not present, it will not change the address in the address bar
	}
	
	@RequestMapping("eventRegisterForm.do")
	public String getRegistrationForm(Model model) {
		model.addAttribute("events", service.getOpenEvents());
		return "register.jsp";
	}
	
	@RequestMapping("register.do")
	public String RegisterableService(HttpServletRequest req) {
		String email = req.getParameter("email");
		String evt = req.getParameter("evt");
		service.register(email, evt);
		return "redirect:index.jsp?registered successfully!!!";
	}
	
	@InitBinder
	public void registerBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
//		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
}
