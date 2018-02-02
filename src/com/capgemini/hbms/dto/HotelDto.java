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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hotel")
public class HotelDto {

	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "hotel_seq")
	private int hotelId;

	@NotEmpty(message="City cannot be empty")
	private String city;

	@Column(name = "hotel_name")
	@NotEmpty(message="Hotel Name cannot be empty")
	@Length(min = 3, message = "Should be more than 3 letters")
	private String hotelName;

	@Column(name = "address")
	@NotEmpty(message="Address cannot be empty")
	@Length(min = 3, message = "Should be more than 3 letters")
	private String hotelAddress;

	@NotEmpty(message="Description cannot be empty")
	@Length(min = 3, message = "Should be more than 3 letters")
	private String description;

	@NotNull
	@Min(value = 1, message = "Minimum value should be Rs.1")
	@Column(name = "avg_rate_per_night")
	private int avgRatePerNight;

	@Length(min = 10, max = 10, message = "Phone number should be 10 digits only")
	@Column(name = "phone_no1")
	private String phoneNo1;

	@Length(min = 10, max = 10, message = "Phone number should be 10 digits only")
	@Column(name = "phone_no2")
	private String phoneNo2;

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

	private String rating;

	@Column(name = "email")
	@Email(message = "Please enter valid email id(Ex: xyz@abc.pqr)")
	@NotEmpty(message = "It cannot be empty")
	private String hotelEmail;

	@Length(min = 10, max = 10, message = "Fax number should be 10 digits only")
	private String fax;

	@Transient
	private int userId;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(int avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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
		return "HotelDto [hotelId=" + hotelId + ", city=" + city + ", hotelName=" + hotelName + ", hotelAddress="
				+ hotelAddress + ", description=" + description + ", avgRatePerNight=" + avgRatePerNight + ", phoneNo1="
				+ phoneNo1 + ", phoneNo2=" + phoneNo2 + ", checkInDate=" + checkInDate + ", checkOutDate="
				+ checkOutDate + ", noOfAdults=" + noOfAdults + ", noOfChildren=" + noOfChildren + ", rating=" + rating
				+ ", hotelEmail=" + hotelEmail + ", fax=" + fax + ", userId=" + userId + "]";
	}
	
	

}
