package com.project.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "user_session")
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Lob
	@Column(name = "token")
	private String token;

	@Column(name = "token_validity", columnDefinition = "datetime not null default current_timestamp")
	private LocalDateTime tokenValidity;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "last_call", columnDefinition = "datetime not null default current_timestamp")
	private LocalDateTime lastCall;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenValidity() {
		return tokenValidity;
	}

	public void setTokenValidity(LocalDateTime tokenValidity) {
		this.tokenValidity = tokenValidity;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public LocalDateTime getLastCall() {
		return lastCall;
	}

	public void setLastCall(LocalDateTime lastCall) {
		this.lastCall = lastCall;
	}

}
