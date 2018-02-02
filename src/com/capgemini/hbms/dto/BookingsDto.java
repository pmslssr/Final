package com.capgemini.hbms.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="bookingdetails")
public class BookingsDto {
	
		@Id
		@Column(name="booking_id")
		@SequenceGenerator(name="seq", sequenceName="booking_seq")
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
		private int bookingId;
		
		@Column(name="hotel_id")
		private int hotelId;
		
		@Column(name="room_id")
		private int roomId;
		
		@Column(name="user_id")
		private int userId;
		
		@DateTimeFormat(iso=ISO.DATE)
		@Column(name="booked_from")
		private Date bookingFrom;
		
		@Column(name="booked_to")
		@DateTimeFormat(iso=ISO.DATE)
		private Date bookingTo;
		
		@Column(name="no_of_adults")
		private int noOfAdults;
		
		@Column(name="no_of_children")
		private int noOfChildren;
		
		private float amount;
		
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
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
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public Date getBookingFrom() {
			return bookingFrom;
		}
		public void setBookingFrom(Date bookingFrom) {
			this.bookingFrom = bookingFrom;
		}
		public Date getBookingTo() {
			return bookingTo;
		}
		public void setBookingTo(Date bookingTo) {
			this.bookingTo = bookingTo;
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
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "BookingsDto [bookingId=" + bookingId + ", hotelId=" + hotelId
					+ ", roomId=" + roomId + ", userId=" + userId
					+ ", bookingFrom=" + bookingFrom + ", bookingTo=" + bookingTo
					+ ", noOfAdults=" + noOfAdults + ", noOfChildren="
					+ noOfChildren + ", amount=" + amount + "]";
		}
}
