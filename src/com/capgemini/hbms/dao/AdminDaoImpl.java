package com.capgemini.hbms.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao {

	HotelDto hotelDto;
	RoomDto roomDto;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String getRole(String name, String pass) throws HotelException {
		String query = "SELECT b from UserDto b WHERE b.userName =:USER_NAME AND b.password =:PASSWORD";
		TypedQuery<UserDto> queryOne = entityManager.createQuery(query, UserDto.class);
		queryOne.setParameter("USER_NAME", name);
		queryOne.setParameter("PASSWORD", pass);
		UserDto usr = queryOne.getSingleResult();
		return usr.getRole();
	}

	@Override
	public List<HotelDto> getAllHotels() throws HotelException {
		List<HotelDto> hotelList;
		String getHotelQuery = "from HotelDto";
		TypedQuery<HotelDto> query = entityManager.createQuery(getHotelQuery, HotelDto.class);
		hotelList = query.getResultList();
		entityManager.flush();

		return hotelList;
	}

	@Override
	public int addNewHotel(HotelDto hotelDto) throws HotelException {
		entityManager.persist(hotelDto);
		entityManager.flush();
		return hotelDto.getHotelId();
	}

	@Override
	public void deleteHotel(int hotelId) throws HotelException {
		try {
			hotelDto = entityManager.find(HotelDto.class, hotelId);
			entityManager.remove(hotelDto);
			entityManager.flush();
		} catch (Exception e) {
			throw new HotelException("Hotel cannot be deleted because child records exist.");
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	@Override
	public HotelDto retrieveHotelData(int hotelId) throws HotelException {
			hotelDto = entityManager.find(HotelDto.class, hotelId);
			entityManager.flush();
			return hotelDto;
	}

	@Override
	public void updateHotel(HotelDto hotel) {
		HotelDto hotelDto = entityManager.find(HotelDto.class, hotel.getHotelId()); // Consider em as JPA EntityManager
		System.out.println(hotelDto);
		entityManager.merge(hotel);

		entityManager.flush();

	}

	@Override
	public void addNewRoom(RoomDto roomDto) {
		entityManager.persist(roomDto);
		entityManager.flush();
	}

	@Override
	public List<RoomDto> getAllRooms(int hotelId) {
		List<RoomDto> hotelRoomsList;

		String getHotelQuery = "SELECT rooms FROM RoomDto rooms WHERE rooms.hotelId=:hotelId";

		TypedQuery<RoomDto> query = entityManager.createQuery(getHotelQuery, RoomDto.class);
		query.setParameter("hotelId", hotelId);
		hotelRoomsList = query.getResultList();

		return hotelRoomsList;
	}

	@Override
	public void deleteRoom(int roomId) {
		
		roomDto = entityManager.find(RoomDto.class, roomId);
		entityManager.remove(roomDto);
		entityManager.flush();
		
	}
	
	@Override
	public RoomDto updateRooms(int roomId) {
		RoomDto roomDto;
		roomDto = entityManager.find(RoomDto.class, roomId);
		entityManager.flush();
		return roomDto;
	}

	@Override
	public void updateRoomDetails(RoomDto roomDto) {
		RoomDto roomToUpdate = entityManager.find(RoomDto.class, roomDto.getRoomId());

		entityManager.merge(roomDto);
		entityManager.flush();

	}

	@Override
	public List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) {
		List<BookingsDto> listOfBookings;
		String specifiedDateBookingsQuery = "SELECT bookings FROM BookingsDto bookings WHERE bookings.hotelId ="
				+ hotelId;
		TypedQuery<BookingsDto> bookings = entityManager.createQuery(specifiedDateBookingsQuery, BookingsDto.class);
		listOfBookings = bookings.getResultList();
		return listOfBookings;
	}

	@Override
	public List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException {
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");

		Date date1 = null;
		try {
//			date1 = format1.parse(specificDate);
//			String dateTransformed1 = format2.format(date1);
//			System.out.println("in dao date is " + dateTransformed1);
			List<BookingsDto> listOfBookings;
			String specifiedDateBookingsQuery = "SELECT bookings FROM BookingsDto bookings WHERE bookings.bookingFrom ="
					+ specificDate ;
			TypedQuery<BookingsDto> bookings = entityManager.createQuery(specifiedDateBookingsQuery, BookingsDto.class);
			listOfBookings = bookings.getResultList();
			return listOfBookings;
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		
	}

}
