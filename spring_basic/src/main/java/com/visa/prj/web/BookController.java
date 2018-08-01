package com.visa.prj.web;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Address;
import com.visa.prj.entity.Book;

@Controller
public class BookController {
	
		@Autowired
		private BookValidator validator;

		@RequestMapping("bookform.do")
		public String getBookForm(Model model) { //variant of ModelAndView
			model.addAttribute("book", new Book());
			return "bookform.jsp";
		}
		
		@RequestMapping("addBook.do")
		public String addBook(@ModelAttribute("book") Book b, BindingResult errors) {
			validator.validate(b, errors);
			if(errors.hasErrors()) {
				return "bookform.jsp";
			}
			System.out.println(b.getTitle());
			System.out.println(b.getPrice());
			System.out.println(b.getCategory());
			System.out.println(b.getPublishedDate());
			System.out.println(b.getPublisherAddress());
			return "redirect:index.jsp"; // redirect is needed to redirect | if redirect not present, it will not change the address in the address bar
		}
		
		@InitBinder
		public void registerBinder(WebDataBinder binder) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//			sdf.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
			binder.registerCustomEditor(Address.class, new AddressPropertyEditor());
		}
}
