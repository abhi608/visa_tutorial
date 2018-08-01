package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.User;
import com.visa.prj.service.EventService;

@Controller
public class UserController {
	
		@Autowired
		private EventService service;

		@RequestMapping("userForm.do")
		public String getUserForm(Model model) { //variant of ModelAndView
			model.addAttribute("user", new User());
			return "userform.jsp";
		}
		
		@RequestMapping("addUser.do")
		public String addUser(@ModelAttribute("book") User u) {
			u.setId(0);
			service.insertUser(u);
			return "redirect:index.jsp"; // redirect is needed to redirect | if redirect not present, it will not change the address in the address bar
		}
		
		
}
