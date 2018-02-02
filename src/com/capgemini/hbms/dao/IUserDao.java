package com.capgemini.hbms.dao;

import java.util.List;

import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.dto.UserDto;
import com.capgemini.hbms.exception.HotelException;


public interface IUserDao {

	int addNewUser(UserDto userDto) throws HotelException;
	
	List<HotelDto> getAllHotelsByCity(String city) throws HotelException;
	
	List<RoomDto> getAllRooms(int hotelId);
	
	RoomDto retrieveRoomDataById(int roomId);
	
	float getPerNightRate(int roomId) throws HotelException;
	
	int bookHotel(BookingsDto selectedRoom,int hotelId,int roomId) throws HotelException;
	
	List<BookingsDto> displayBookings(int bookingId);
}
