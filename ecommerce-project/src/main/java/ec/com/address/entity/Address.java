package ec.com.address.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.Data;

@Table(name = "user_address")
@Data
@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;

	@Max(value = 6, message = "Invalid pin code")
	@Column(name = "pincode")
	private int pincode;
}
