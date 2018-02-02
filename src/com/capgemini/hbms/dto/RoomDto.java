package com.capgemini.hbms.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "roomdetails")
public class RoomDto {

	@Id
	@Column(name = "room_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "room_seq")
	private int roomId;

	@Column(name = "hotel_id")
	private int hotelId;

	@Transient
	private int userId;
	
	@Column(name = "room_Type")
	@NotEmpty(message="Room Type cannot be empty")
	private String roomType;
	
	@Column(name = "per_Night_Rate")
	@Min(value = 1, message = "Minimum value should be Rs.1")
	private float perNightRate;
	
	@Column(name = "availability")
	private int availability;
	
	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;

	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOutDate;

	@Transient
	private int noOfAdults;

	@Transient
	private int noOfChildren;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPerNightRate() {
		return perNightRate;
	}

	public void setPerNightRate(float perNightRate) {
		this.perNightRate = perNightRate;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", hotelId=" + hotelId + ", userId=" + userId + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", availability=" + availability + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", noOfAdults=" + noOfAdults + ", noOfChildren=" + noOfChildren
				+ "]";
	}
	
	

}
