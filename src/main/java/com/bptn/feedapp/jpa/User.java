package com.bptn.feedapp.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
@Entity
@Table(name="\"User\"")
public class User implements Serializable {    
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"userId\"")
	private Integer userId;
	
	@Column(name="\"firstName\"")
	private String firstName;

	@Column(name="\"lastName\"")
	private String lastName;

	@Column(unique=true)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private String phone;

	@Column(name="\"emailId\"", unique=true)
	private String emailId;

	@Column(name="\"emailVerified\"")
	private Boolean emailVerified;

	
	public User() {
		
	}
	
	@Column(name="\"createdOn\"")
	private Timestamp createdOn;

	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Profile profile;

	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Feed> feeds;

	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<FeedMetaData> feedMetaData;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public List<FeedMetaData> getFeedMetaData() {
		return feedMetaData;
	}

	public void setFeedMetaData(List<FeedMetaData> feedMetaData) {
		this.feedMetaData = feedMetaData;
	}

	
	
	@Override
	public String toString() {
		return String.format(
				"User [userId=%s, firstName=%s, lastName=%s, username=%s, password=%s, phone=%s, emailId=%s, emailVerified=%s, createdOn=%s, profile=%s, feeds=%s, feedMetaData=%s]",
				userId, firstName, lastName, username, password, phone, emailId, emailVerified, createdOn, profile,
				feeds, feedMetaData);
	}
}

