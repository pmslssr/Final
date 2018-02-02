package com.capgemini.hbms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class UserDto {

		@Id
		@Column(name="user_id")
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
		@SequenceGenerator(name="seq", sequenceName="user_seq",allocationSize=1)
		private int userid;
		@Column(name="first_name")
		@NotEmpty(message="First Name cannot be empty")
		private String firstName;
		@Column(name="last_name")
		@NotEmpty(message="Last Name cannot be empty")
		private String lastName;
		@NotEmpty(message="password cannot be empty")
		private String password;
		private String role;
		@Column(name="user_name")
		@NotEmpty(message="username cannot be empty")
		private String userName;
		@Column(name="mobile_no")
		private String mobileNo;
		private String phone;
		@NotEmpty(message="Address cannot be empty")
		private String address;
		@NotEmpty(message="Email cannot be empty")
		private String email;
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	

}
