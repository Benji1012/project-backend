package szakdoga.Balatoni_szallas.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Reservation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false)
		private Long reservationId;
		@Column(nullable = false)
		private Long userId;
		@Column(nullable = false)
		private String apartmanName;
//		@Column(nullable = false)
//	    private Long apartmanId;
		@Column(nullable = false)
	    private Integer numberofNights;
		@Column(nullable = false)
	    private Integer price;
		@Temporal(TemporalType.DATE)
		private Date resFrom;
		@Temporal(TemporalType.DATE)
		private Date resTo;
		
		@ManyToOne
	    @JoinColumn(name = "apartmanId")
	    private Apartman apartman;
	    
	    public Reservation() {  	
	    	this.numberofNights = 0;
	    	this.price = 0;
	    	this.apartmanName = "";
	    	this.resFrom = null;
	    	this.resTo = null;
	    	
	    }

		public Long getReservationId() {
			return reservationId;
		}

		public void setReservationId(Long reservationId) {
			this.reservationId = reservationId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

//		public Long getApartmanId() {
//			return apartmanId;
//		}
//
//		public void setApartmanId(Long apartmanId) {
//			this.apartmanId = apartmanId;
//		}

		public Integer getNumberofNights() {
			return numberofNights;
		}

		public void setNumberofNights(Integer numberofNights) {
			this.numberofNights = numberofNights;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public String getApartmanName() {
			return apartmanName;
		}

		public void setApartmanName(String apartmanName) {
			this.apartmanName = apartmanName;
		}

		public Date getResFrom() {
			return resFrom;
		}

		public void setResFrom(Date resFrom) {
			this.resFrom = resFrom;
		}

		public Date getResTo() {
			return resTo;
		}

		public void setResTo(Date resTo) {
			this.resTo = resTo;
		}

		public Apartman getApartman() {
			return apartman;
		}

		public void setApartman(Apartman apartman) {
			this.apartman = apartman;
		}
		 
}
