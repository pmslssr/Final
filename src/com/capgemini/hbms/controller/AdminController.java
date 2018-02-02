package com.capgemini.hbms.controller;

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
import com.capgemini.hbms.exception.HotelException;
import com.capgemini.hbms.service.IAdminService;

@Controller
public class AdminController {

	ModelAndView mv;
	@Autowired
	IAdminService adminService;

	@RequestMapping("/adminHome")
	public ModelAndView home() {

		mv = new ModelAndView("AdminHome");
		return mv;

	}
	

	@RequestMapping("/hotelManagement")
	public ModelAndView hotelManagementOperations() {
		List<HotelDto> hotelList;
		try {
			hotelList = adminService.getAllHotels();
			mv = new ModelAndView("HotelManagement");
			mv.addObject("hotelList", hotelList);
			return mv;

		} catch (HotelException e) {
			mv = new ModelAndView("error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}

	}

	@RequestMapping(value = "/addHotel", method = RequestMethod.POST)
	public ModelAndView addHotel() {
		mv = new ModelAndView("AddHotel");
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

		ArrayList<String> rating = new ArrayList<String>();
		rating.add("1");
		rating.add("2");
		rating.add("3");
		rating.add("4");
		rating.add("5");
		mv.addObject("rating", rating);
		mv.addObject("add", new HotelDto());
		return mv;

	}

	@RequestMapping("/addHotelData")
	public ModelAndView addHotelData(@ModelAttribute("add") @Valid HotelDto hotelDto, BindingResult result) {

		if (result.hasErrors()) {
			mv = new ModelAndView("AddHotel");
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

			ArrayList<String> rating = new ArrayList<String>();
			rating.add("1");
			rating.add("2");
			rating.add("3");
			rating.add("4");
			rating.add("5");
			mv.addObject("rating", rating);

			return mv;
		} else {

			try {
				adminService.addNewHotel(hotelDto);
				List<HotelDto> hotelList = adminService.getAllHotels();
				mv = new ModelAndView("HotelManagement");
				mv.addObject("hotelList", hotelList);
				return mv;

			} catch (HotelException e) {

				mv = new ModelAndView("Error");
				mv.addObject("exception", e.getMessage());
				return mv;
			}

		}

	}

	@RequestMapping("/deleteHotel")
	public ModelAndView deleteHotel(@RequestParam("hId") int hotelId) {

		try {
			adminService.deleteHotel(hotelId);
			List<HotelDto> hotelList = adminService.getAllHotels();
			mv = new ModelAndView("HotelManagement");
			mv.addObject("hotelList", hotelList);
			return mv;
		} catch (HotelException e) {

			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}

	}

	@RequestMapping("/updateHotel")
	public ModelAndView updateHotel(@RequestParam("hId") int hotelId) {
		HotelDto hotelData;
		try {
			hotelData = adminService.retrieveHotelData(hotelId);
			mv = new ModelAndView("UpdateHotel");
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

			ArrayList<String> rating = new ArrayList<String>();
			rating.add("1");
			rating.add("2");
			rating.add("3");
			rating.add("4");
			rating.add("5");
			mv.addObject("rating", rating);

			mv.addObject("hotelData", hotelData);
			mv.addObject("update", new HotelDto());
			return mv;
		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}
		

	}

	@RequestMapping(value = "/updateHotelData", method = RequestMethod.POST)
	public ModelAndView updateHotel(@ModelAttribute("update") @Valid HotelDto hotel, BindingResult result) {
		HotelDto hotelData;
		try {
			hotelData = adminService.retrieveHotelData(hotel.getHotelId());
			if (result.hasErrors()) {

				mv = new ModelAndView("UpdateHotel");
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

				ArrayList<String> rating = new ArrayList<String>();
				rating.add("1");
				rating.add("2");
				rating.add("3");
				rating.add("4");
				rating.add("5");
				mv.addObject("rating", rating);
				mv.addObject("hotelData", hotelData);
				return mv;
			} else {

				try {
					System.out.println(hotel.toString());
					adminService.updateHotel(hotel);

					List<HotelDto> hotelList;

					hotelList = adminService.getAllHotels();
					mv = new ModelAndView("HotelManagement");
					mv.addObject("hotelList", hotelList);
					return mv;
				} catch (HotelException e) {
					mv = new ModelAndView("Error");
					mv.addObject("exception", e.getMessage());
					return mv;
				}
			}
		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}
		
	}

	@RequestMapping("/roomList")
	public ModelAndView hotelRoom() {

		mv = new ModelAndView("HotelRooms");
		return mv;

	}
	
	@RequestMapping("/roomManagement")
	public ModelAndView roomManagementOperations() {
		List<HotelDto> hotelList;
		try {
			hotelList = adminService.getAllHotels();
			mv = new ModelAndView("RoomManagement");
			mv.addObject("hotelList", hotelList);
			return mv;

		} catch (HotelException e) {
			mv = new ModelAndView("Error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}

	}
	
	@RequestMapping("/hotelRooms")
	public ModelAndView hotelRooms(@RequestParam("hId") int hotelId) {

		List<RoomDto> hotelRooms;
		hotelRooms = adminService.getAllRooms(hotelId);

		mv = new ModelAndView("HotelRooms");
		mv.addObject("hotelRooms", hotelRooms);
		mv.addObject("hotelId", hotelId);
		return mv;

	}

	@RequestMapping("/addRoom")
	public ModelAndView addRoom(@RequestParam("hId") int hotelId) {
		mv = new ModelAndView("AddRoom");
		mv.addObject("addRoom", new RoomDto());
		mv.addObject("hotelId", hotelId);
		return mv;

	}

	@RequestMapping("/addRoomData")
	public ModelAndView addRoomData(@ModelAttribute("addRoom") @Valid RoomDto roomDto, BindingResult result) {

		if (result.hasErrors()) {
			mv = new ModelAndView("AddRoom");
			return mv;
		} else {

			adminService.addNewRoom(roomDto);

			List<RoomDto> hotelRooms = adminService.getAllRooms(roomDto.getHotelId());
			mv = new ModelAndView("HotelRooms");
			mv.addObject("hotelRooms", hotelRooms);
			mv.addObject("hotelId", roomDto.getHotelId());
			return mv;
		}
	}
	
	
	@RequestMapping("/deleteRooms")
	public ModelAndView deleteRoom(@RequestParam("hId") int hotelId, @RequestParam("rId") int roomId) {

		adminService.deleteRoom(roomId);

		List<RoomDto> hotelRooms = adminService.getAllRooms(hotelId);
		mv = new ModelAndView("HotelRooms");

		mv.addObject("hotelRooms", hotelRooms);
		return mv;

	}
	
	@RequestMapping("/updateRooms")
	public ModelAndView updateRooms(@RequestParam("hId") int hotelId, @RequestParam("rId") int roomId) {

		RoomDto roomDto = adminService.updateRooms(roomId);

		ModelAndView mv = new ModelAndView("UpdateRooms");
		mv.addObject("roomDto", roomDto);
		mv.addObject("updateRoom", new RoomDto());
		return mv;

	}

	@RequestMapping("/updateRoomData")
	public ModelAndView updateOneRoom(@ModelAttribute("updateRoom") RoomDto roomDto) {

		List<RoomDto> hotelRooms;
		adminService.updateRoomDetails(roomDto);
		hotelRooms = adminService.getAllRooms(roomDto.getHotelId());

		mv = new ModelAndView("HotelRooms");
		mv.addObject("hotelRooms", hotelRooms);

		return mv;

	}
	
	@RequestMapping("/viewDetails")
	public ModelAndView viewDetails() {
		mv = new ModelAndView("ViewDetails");
		return mv;

	}
	
	@RequestMapping("/viewListOfHotels")
	public ModelAndView viewAllHotels() {
		List<HotelDto> hotelList;
		try {
			hotelList = adminService.getAllHotels();
			mv = new ModelAndView("ViewAllHotels");
			mv.addObject("hotelList", hotelList);
			return mv;

		} catch (HotelException e) {
			mv = new ModelAndView("error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}
	}
	
	@RequestMapping("/viewBookingsOfSpecificHotel")
	public ModelAndView viewBookingsOfSpecificHotel() {
		ModelAndView mv = new ModelAndView("ViewBookingsOfSpecificHotel");
		mv.addObject("bookingsDto", new BookingsDto());

		return mv;

	}

	@RequestMapping("/displayBookingsForSpecificHotel")
	public ModelAndView displayBookingsForSpecificHotel(@RequestParam("hotelId") int hotelId) {

		List<BookingsDto> bookingsDto = adminService.displayBookingsForSpecificHotel(hotelId);
		ModelAndView mv = new ModelAndView("DisplayBookingsForSpecificHotel");
		mv.addObject("bookingsDto", bookingsDto);

		mv.addObject("bookingId", bookingsDto.get(0).getBookingId());

		return mv;

	}
	
	@RequestMapping("/bookingDetailsForSpecificDate")
	public ModelAndView bookingDetailsForSpecificDate() {

		ModelAndView mv = new ModelAndView("BookingDetailsForSpecificDate");
		mv.addObject("bookingDto", new BookingsDto());

		return mv;

	}

	@RequestMapping("/showDetailsForSpecificDate")
	public ModelAndView showDetailsForSpecificDate(@RequestParam("date") String specificDate) {

		List<BookingsDto> bookingsDto;
		try {
			bookingsDto = adminService.showDetailsForSpecificDate(specificDate);
			ModelAndView mv = new ModelAndView("DisplayBookingsForSpecificDate");
			mv.addObject("bookingsDto", bookingsDto);
			return mv;
		} catch (HotelException e) {
			mv = new ModelAndView("error");
			mv.addObject("exception", e.getMessage());
			return mv;
		}
		

	}

}
