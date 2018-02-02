package com.capgemini.hbms.dao;

import java.util.List;

import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.exception.HotelException;




public interface IAdminDao {

	public String getRole(String name, String pass) throws HotelException;
	
	List<HotelDto> getAllHotels() throws HotelException;
	
	int addNewHotel(HotelDto hotelDto) throws HotelException;
	
	void deleteHotel(int hotelId) throws HotelException;
	
	HotelDto retrieveHotelData(int hotelId) throws HotelException;
	
	void updateHotel(HotelDto hotel);
	
	void addNewRoom(RoomDto roomDto);
	
	List<RoomDto> getAllRooms(int hotelId);
	
	void deleteRoom(int roomId);
	
	RoomDto updateRooms(int roomId);
	
	void updateRoomDetails(RoomDto roomDto);
	
	List<BookingsDto> displayBookingsForSpecificHotel(int hotelId);
	
	List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException;
}
