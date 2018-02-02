package com.capgemini.hbms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hbms.dto.UserDto;
import com.capgemini.hbms.exception.HotelException;
import com.capgemini.hbms.service.IAdminService;

@Controller
public class LoginController {

	ModelAndView mv;
	@Autowired
	IAdminService adminService;

	@RequestMapping("/")
	public ModelAndView first() {

		mv = new ModelAndView("Login");
		mv.addObject("login", new UserDto());
		return mv;

	}

	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();
		mv = new ModelAndView("Login");
		mv.addObject("login", new UserDto());
		return mv;

	}

	@RequestMapping("/validateLogin")
	public ModelAndView validateLogin(@RequestParam("userName") String name, @RequestParam("password") String pass,
			@ModelAttribute("login") @Valid UserDto dto, BindingResult result) {

//		if (result.hasErrors()) {
//			mv = new ModelAndView("Login");
//			return mv;
//		} else {
			String role;
			try {
				role = adminService.getRole(name, pass);
				if (role.equals("User")) {
					mv = new ModelAndView("UserHome");
					return mv;
				}

				else if (role.equals("Employee")) {
					mv = new ModelAndView("UserHome");
					return mv;
				}

				else if (role.equals("Admin")) {
					mv = new ModelAndView("AdminHome");
					return mv;
				} else {
					mv = new ModelAndView("Error");
					return mv;
				}

			} catch (HotelException e) {
				mv = new ModelAndView("Error");
				mv.addObject("exception", e.getMessage());
				return mv;
			}
		}
//	}

}
