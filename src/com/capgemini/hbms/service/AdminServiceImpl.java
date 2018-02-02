package com.capgemini.hbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.hbms.dao.IAdminDao;
import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.exception.HotelException;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminDao adminDao;
	
	@Override
	public String getRole(String name, String pass) throws HotelException {
		
		return adminDao.getRole(name, pass);
	}

	@Override
	public List<HotelDto> getAllHotels() throws HotelException {

		return adminDao.getAllHotels();
	}

	@Override
	public int addNewHotel(HotelDto hotelDto) throws HotelException {
		
		return adminDao.addNewHotel(hotelDto);
	}

	@Override
	public void deleteHotel(int hotelId) throws HotelException {
		
		adminDao.deleteHotel(hotelId);	
	}

	@Override
	public HotelDto retrieveHotelData(int hotelId) throws HotelException {

		return adminDao.retrieveHotelData(hotelId);
	}

	@Override
	public void updateHotel(HotelDto hotel) {
		
		adminDao.updateHotel(hotel);	
	}

	@Override
	public void addNewRoom(RoomDto roomDto) {
		
		adminDao.addNewRoom(roomDto);	
	}

	@Override
	public List<RoomDto> getAllRooms(int hotelId) {
	
		return adminDao.getAllRooms(hotelId);
	}

	@Override
	public void deleteRoom(int roomId) {
		
		adminDao.deleteRoom(roomId);
	}

	@Override
	public RoomDto updateRooms(int roomId) {
		
		return adminDao.updateRooms(roomId);
	}

	@Override
	public void updateRoomDetails(RoomDto roomDto) {
		
		adminDao.updateRoomDetails(roomDto);	
	}

	@Override
	public List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) {

		return adminDao.displayBookingsForSpecificHotel(hotelId);
	}

	@Override
	public List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException {
		
		return adminDao.showDetailsForSpecificDate(specificDate);
	}

}
