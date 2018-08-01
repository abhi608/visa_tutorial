package com.visa.prj.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

		@RequestMapping("first.do")
		public ModelAndView doFirstTask() {
			ModelAndView mav = new ModelAndView();
			mav.addObject("date", new Date());
			mav.addObject("name", "Ethan");
			
			mav.setViewName("print.jsp");
			return mav;
		}
}
