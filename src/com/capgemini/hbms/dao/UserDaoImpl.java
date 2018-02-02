package com.capgemini.hbms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.hbms.dto.BookingsDto;
import com.capgemini.hbms.dto.HotelDto;
import com.capgemini.hbms.dto.RoomDto;
import com.capgemini.hbms.dto.UserDto;
import com.capgemini.hbms.exception.HotelException;


@Repository("userDao")
public class UserDaoImpl implements IUserDao{

	RoomDto roomDto;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addNewUser(UserDto userDto) throws HotelException {
		entityManager.persist(userDto);
		entityManager.flush();
		return userDto.getUserid();
	}

	@Override
	public List<HotelDto> getAllHotelsByCity(String city) throws HotelException {
		List<HotelDto> hotelList;
		String getHotelQuery = "SELECT h from HotelDto h where city = :CITY";
		TypedQuery<HotelDto> queryOne = entityManager.createQuery(getHotelQuery, HotelDto.class);
		queryOne.setParameter("CITY", city);

		hotelList = queryOne.getResultList();
		entityManager.flush();
		return hotelList;
	}

	@Override
	public List<RoomDto> getAllRooms(int hotelId) {
		List<RoomDto> hotelRoomsList;

		String getHotelQuery = "SELECT rooms FROM RoomDto rooms where rooms.hotelId=:hotelId";

		TypedQuery<RoomDto> query = entityManager.createQuery(getHotelQuery, RoomDto.class);
		System.out.println("in dao after q");
		query.setParameter("hotelId", hotelId);
		hotelRoomsList = query.getResultList();

		return hotelRoomsList;
	}

	@Override
	public RoomDto retrieveRoomDataById(int roomId) {
		roomDto = entityManager.find(RoomDto.class, roomId);
		entityManager.flush();
		return roomDto;
	}

	@Override
	public float getPerNightRate(int roomId) throws HotelException {
		RoomDto room = entityManager.find(RoomDto.class, roomId);
		return room.getPerNightRate();
	}

	@Override
	public int bookHotel(BookingsDto selectedRoom, int hotelId, int roomId) throws HotelException {
		entityManager.persist(selectedRoom);
		entityManager.flush();
//		String update = "UPDATE RoomDto room SET room.availability= 0 WHERE room.hotelId=:hotelId AND room.roomId=:roomId";
//		TypedQuery<RoomDto> query = entityManager.createQuery(update, RoomDto.class);
//		query.setParameter("hotelId", hotelId);
//		query.setParameter("roomId", roomId);
//		query.executeUpdate();

		return selectedRoom.getBookingId();
	}

	@Override
	public List<BookingsDto> displayBookings(int bookingId) {
		List<BookingsDto> listOfBookings;
		String specifiedBookingQuery = "SELECT bookings FROM BookingsDto bookings WHERE bookings.bookingId ="
				+ bookingId;
		TypedQuery<BookingsDto> bookings = entityManager.createQuery(specifiedBookingQuery, BookingsDto.class);
		listOfBookings = bookings.getResultList();
		return listOfBookings;
	}
	
	
}
