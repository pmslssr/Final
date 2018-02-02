package com.capgemini.hbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.hbms.dao.IUserDao;
import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.dto.UserDto;
import com.capgemini.hbms.exception.HotelException;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
	public int addNewUser(UserDto userDto) throws HotelException {
		
		return userDao.addNewUser(userDto);
	}

	@Override
	public List<HotelDto> getAllHotelsByCity(String city) throws HotelException {
		
		return userDao.getAllHotelsByCity(city);
	}

	@Override
	public List<RoomDto> getAllRooms(int hotelId) {
		
		return userDao.getAllRooms(hotelId);
	}

	@Override
	public RoomDto retrieveRoomDataById(int roomId) {

		return userDao.retrieveRoomDataById(roomId);
	}

	@Override
	public float getPerNightRate(int roomId) throws HotelException {

		return userDao.getPerNightRate(roomId);
	}

	@Override
	public int bookHotel(BookingsDto selectedRoom, int hotelId, int roomId) throws HotelException {

		return userDao.bookHotel(selectedRoom, hotelId, roomId);
	}

	@Override
	public List<BookingsDto> displayBookings(int bookingId) {
		
		return userDao.displayBookings(bookingId);
	}

}
