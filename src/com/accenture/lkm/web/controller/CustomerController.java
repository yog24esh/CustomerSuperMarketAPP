package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

//	@RequestMapping(value = "/LoadPizzaOrder", method = RequestMethod.GET)
//	public ModelAndView loadSavePizza() throws Exception {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("PizzaOrder");
//		modelAndView.addObject("pizzaOrderObj",new PizzaOrderBean());
//		return modelAndView;
//
//	}
	
	@RequestMapping(value="/addCustomer.html",method=RequestMethod.GET)
	public ModelAndView loadCustomerViews() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addCustomerPage");
		mv.addObject("customerObj", new CustomerBean());
		return mv;
	}
	
	
	
	@RequestMapping(value="/SaveCustomer.html",method = RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customerObj") CustomerBean bean) throws Exception {
		ModelAndView mv = new ModelAndView();
		Integer id= service.addCustomer(bean);
		mv.setViewName("successViews");
		mv.addObject("id", id);
		return mv;
		
	}
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
