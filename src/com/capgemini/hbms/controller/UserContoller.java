package com.capgemini.hbms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.dto.UserDto;
import com.capgemini.hbms.exception.HotelException;
import com.capgemini.hbms.service.IUserService;
@Controller
public class UserContoller {

	ModelAndView mv;
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView addUser() {

		mv = new ModelAndView("Register");
		List<String> userList = new ArrayList<String>();

		userList.add("Employee");
		userList.add("User");
		mv.addObject("userList", userList);
		mv.addObject("user", new UserDto());

		return mv;
	}

	@RequestMapping("/addUserData")
	public ModelAndView addUserData(@ModelAttribute("user") @Valid UserDto loginDto, BindingResult result) {

		if (result.hasErrors()) {
			mv = new ModelAndView("Register");
			List<String> userList = new ArrayList<String>();

			userList.add("Employee");
			userList.add("User");
			mv.addObject("userList", userList);

			return mv;
		} else {

			try {
				userService.addNewUser(loginDto);
				mv = new ModelAndView("UserHome");
				return mv;

			} catch (HotelException e) {

				mv = new ModelAndView("Error");
				mv.addObject("exception", e.getMessage());
				return mv;
			}

		}

	}

	@RequestMapping("/userHome")
	public ModelAndView home() {

		mv = new ModelAndView("UserHome");
		return mv;

	}

	@RequestMapping(value = "/searchForHotels")
	public ModelAndView searchHotels() {
		mv = new ModelAndView("SearchForHotels");
		ArrayList<String> cityList = new ArrayList<String>();
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Pune");
		cityList.add("Goa");
		cityList.add("Vizag");
		cityList.add("New Delhi");
		mv.addObject("cityList", cityList);
		mv.addObject("hotelInfo", new HotelDto());
		return mv;
	}

	@RequestMapping(value = "/viewAllHotelsByCity")
	public ModelAndView viewAllHotels(@RequestParam("city") String city,@ModelAttribute("hotelInfo") HotelDto hotelInfo) {

		List<HotelDto> hotelList;
		try {
			hotelList = userService.getAllHotelsByCity(city);
			mv = new ModelAndView("ViewAllHotelsByCity");
			mv.addObject("hotelList", hotelList);
			return mv;
		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}

	}

	@RequestMapping(value = "/bookHotelRooms")
	public ModelAndView bookHotels() {

		mv = new ModelAndView("BookForHotels");
		ArrayList<String> cityList = new ArrayList<String>();
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Pune");
		cityList.add("Goa");
		cityList.add("Vizag");
		cityList.add("New Delhi");
		mv.addObject("cityList", cityList);
		HotelDto hotelInfo = new HotelDto();
		mv.addObject("hotelInfo", hotelInfo);
		LocalDate date1 = LocalDate.now().plusDays(1);
		LocalDate date2 = date1.plusMonths(2);
		mv.addObject("minDate", date1);
		mv.addObject("maxDate", date2);
		return mv;

	}

	@RequestMapping(value = "/bookHotelsByCity")
	public ModelAndView search(@RequestParam("city") String city, @ModelAttribute("hotelInfo") HotelDto hotelInfo) {

		List<HotelDto> hotelList;
		try {
			hotelList = userService.getAllHotelsByCity(city);
			mv = new ModelAndView("BookHotelsByCity");
			mv.addObject("hotelList", hotelList);
			return mv;
		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}

	}
	
	@RequestMapping("/bookHotel")
	public ModelAndView bookHotel(@RequestParam("hId") int hotelId) {
		List<RoomDto> hotelRooms;
		hotelRooms = userService.getAllRooms(hotelId);

		mv = new ModelAndView("BookHotel");
		mv.addObject("bookHotel", hotelRooms);
		mv.addObject("hotelId", hotelId);
		return mv;

	}
	
	float price=0.0f;
	@RequestMapping("/bookHotelRoom")
	public ModelAndView bookRooms(@RequestParam("hId") int hotelId, @RequestParam("rId") int roomId) throws HotelException {

		RoomDto roomDto = userService.retrieveRoomDataById(roomId);
		price=userService.getPerNightRate(roomId);
		ModelAndView mv = new ModelAndView("BookHotelRoom");
		LocalDate date1 = LocalDate.now().plusDays(1);
		LocalDate date2 = date1.plusMonths(2);
		mv.addObject("minDate", date1);
		mv.addObject("maxDate", date2);
		mv.addObject("roomDto", roomDto);
		mv.addObject("room", new BookingsDto());
		return mv;

	}
	
	@RequestMapping("/insertIntoBooking")
	public ModelAndView finalBooking(@ModelAttribute("room") BookingsDto selectedRoom ) {
		
		int guests = selectedRoom.getNoOfAdults() + selectedRoom.getNoOfChildren();
		
		selectedRoom.setAmount(price * guests);
		try {
			
			int booked = userService.bookHotel(selectedRoom,selectedRoom.getHotelId(),selectedRoom.getRoomId());
			mv = new ModelAndView("BookingSuccess");
			mv.addObject("booked",booked);
			return mv;
			
		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}
	}
	
	@RequestMapping("/viewBookingDetails")
	public ModelAndView viewBookingsOfSpecificHotel() {
		ModelAndView mv = new ModelAndView("ViewBookingDetails");
		mv.addObject("bookingsDto", new BookingsDto());

		return mv;

	}

	@RequestMapping("/displayBookingDetails")
	public ModelAndView displayBookingsForSpecificHotel(@RequestParam("bookingId") int bookingId) {

		List<BookingsDto> bookingsDto = userService.displayBookings(bookingId);
		ModelAndView mv = new ModelAndView("DisplayBookingDetails");
		mv.addObject("bookingsDto", bookingsDto);

		mv.addObject("bookingId", bookingsDto.get(0).getBookingId());

		return mv;

	}
}
