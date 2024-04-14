package szakdoga.Balatoni_szallas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
//import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Data
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
//	private String hashedId;
//	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String mobil;
	@Column(nullable = false)
	private String password;
//	private String password;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String personalId;
	@Column(nullable = false)
	private String taxIdNumber;
	@Column(nullable = false)
	private Boolean isPrivatePerson;
	@Column(nullable = false)
	private Role role;

	@Column(nullable = false)
	private Integer loyaltyPoint;
	
	public User() {
		this.username = "";
		this.name = "";
		this.email = "";
		this.mobil = "";
		this.password = "";
		this.city = "";
		this.address = "";
		this.personalId = "";
		this.taxIdNumber = "";
		this.isPrivatePerson = false;
		this.role = Role.USER ;
		this.loyaltyPoint = 0;
//		this.hashedId = "";
	}
	
public Integer getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public void setLoyaltyPoint(Integer loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
        //this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPersonalId() {
		return personalId;
	}
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	public String getTaxIdNumber() {
		return taxIdNumber;
	}
	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}
	public Boolean getIsPrivatePerson() {
		return isPrivatePerson;
	}
	public void setIsPrivatePerson(Boolean isPrivatePerson) {
		this.isPrivatePerson = isPrivatePerson;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
//	public String getHashedId() {
//		return hashedId;
//	}
//
//	public void setHashedId(String hashedId) {
//		this.hashedId = hashedId;
//	}
//	
	
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
