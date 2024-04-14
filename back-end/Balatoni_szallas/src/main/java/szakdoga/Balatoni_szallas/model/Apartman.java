package szakdoga.Balatoni_szallas.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Apartman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long apartmanId;
	@Column(nullable = false)
	private Long ownerId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String website;
	@Column(nullable = false)
	private Integer type;
	@Column(nullable = false)
	private String SportOpportunityType;
	@Column(nullable = false)
	private String Description;
	@Column(nullable = false)
	private Double stars;
	@Column(nullable = false)
	private Double reviewPoints;
	@Column(nullable = false)
	private Integer parkingSlots;
	@Column(nullable = false)
	private Integer numberOfRooms;
	@Column(nullable = false)
	private Integer numberOfPeople;
	@Column(nullable = false)
	private Integer numberOfBeds;
	@Column(nullable = false)
	private Boolean isApproved;
	@Column(nullable = false)
	private Boolean isPartside;
	@Column(nullable = false)
	private Boolean isFood;
	@Column(nullable = false)
	private Boolean isAnimalFriendly;
	@Column(nullable = false)
	private Boolean isSauna;
	@Column(nullable = false)
	private Boolean isPool;
	@Column(nullable = false)
	private Boolean isParking;
	@Column(nullable = false)
	private Boolean isTrambulin;
	@Column(nullable = false)
	private Boolean isPier;
	@Column(nullable = false)
	private Boolean isTabbleTennis;
	@Column(nullable = false)
	private Boolean isBilliard;
	@Column(nullable = false)
	private Boolean isTennis;
	@Column(nullable = false)
	private Boolean isFreeWifi;
	@Column(nullable = false)
	private Boolean isAirCondition;
	@Column(nullable = false)
	private Boolean isJacuzzi;
	@Column(nullable = false)
	private Boolean isMassage;
	@Column(nullable = false)
	private Boolean isKidFriendly;
	@Column(nullable = false)
	private Boolean isPlayground;
	@Column(nullable = false)
	private Boolean isUniversallyAccessable;
	@Column(nullable = false)
	private Boolean isSmoking;
	@Column(nullable = false)
	private Boolean isHungarian;
	@Column(nullable = false)
	private Boolean isEnglisch;
	@Column(nullable = false)
	private Boolean isGerman;
	@Column(nullable = false)
	private Boolean isOtherLanguage;
	@Column(nullable = false)
	private Boolean isHorseRiding;
	@Column(nullable = false)
	private Boolean isSurf;
	@Column(nullable = false)
	private Boolean isFishing;
	@Column(nullable = false)
	private Boolean isBar;
	@Column(nullable = false)
	private Boolean isSeperate;
	@Column(nullable = false)
	private Boolean isOwnerLivesThere;
	@Column(nullable = false)
	private Boolean isNoKid;
	@Column(nullable = false)
	private Boolean isNorth;
	public Boolean getIsNorth() {
		return isNorth;
	}

	public void setIsNorth(Boolean isNorth) {
		this.isNorth = isNorth;
	}

	@Column(nullable = false)
	private Double distBalaton;
	@Column(nullable = false)
	private Double distRail;
	@Column(nullable = false)
	private Double distBus;
	@Column(nullable = false)
	private Double distRestaurant;
	@Column(nullable = false)
	private Double distCitycenter;
	@Column(nullable = false)
	private Double distBudapest;
	@Column(nullable = false)
	private Double distSportOpportunity;
	@Column(nullable = false)
	private Double distPub;
	@Column(nullable = false)
	private Double distGym;
	@Column(nullable = false)
	private Double distHypermarker;
	@Column(nullable = false)
	private Double distSightseeingProgram1;
	@Column(nullable = false)
	private Double distSightseeingProgram2;
	@Column(nullable = false)
	private Double distSightseeingProgram3;
	@Column(nullable = false)
	private String nameSightseeingProgram1;
	@Column(nullable = false)
	private String nameSightseeingProgram2;
	@Column(nullable = false)
	private String nameSightseeingProgram3;
	@Temporal(TemporalType.DATE)
	private Date rentingFrom;
	@Temporal(TemporalType.DATE)
	private Date rentingTo;
	@Column(nullable = false)
	private String image1;
	@Column(nullable = false)
	private String image2;
	@Column(nullable = false)
	private String image3;
	@Column(nullable = false)
	private String image4;
	@Column(nullable = false)
	private String image5;
	@Column(nullable = false)
	private String image6;
	@Column(nullable = false)
	private String image7;
	@Column(nullable = false)
	private String image8;
	@Column(nullable = false)
	private String image9;
	@Column(nullable = false)
	private String image10;
	@Column(nullable = false)
	private Double price;
	
	
	@OneToMany(mappedBy = "apartman")
    private List<Reservation> reservations;
	

	public Apartman() {
		this.address = "";
		this.nameSightseeingProgram3 = "";
		this.nameSightseeingProgram2 = "";
		this.nameSightseeingProgram1 = "";
		this.distSightseeingProgram3 = 0d;
		this.distSightseeingProgram2 = 0d;
		this.distSightseeingProgram1 = 0d;
		this.distHypermarker = 0d;
		this.name = "";
		this.city = "";
		this.mobile = "";
		this.email = "";
		this.website = "";
		this.type = 0;
		this.SportOpportunityType = "";
		this.Description = "";
		this.stars = 0d;
		this.reviewPoints = 0d;
		this.parkingSlots = 0;
		this.isApproved = false;
		this.isPartside = false;
		this.isFood = false;
		this.isAnimalFriendly = false;
		this.isSauna = false;
		this.isPool = false;
		this.isParking = false;
		this.isTrambulin = false;
		this.isPier = false;
		this.isTabbleTennis = false;
		this.isBilliard = false;
		this.isTennis = false;
		this.isFreeWifi = false;
		this.isAirCondition = false;
		this.isJacuzzi = false;
		this.isMassage = false;
		this.isKidFriendly = false;
		this.isPlayground = false;
		this.isUniversallyAccessable = false;
		this.isSmoking = false;
		this.isHungarian = false;
		this.isEnglisch = false;
		this.isGerman = false;
		this.isOtherLanguage = false;
		this.isHorseRiding = false;
		this.isSurf = false;
		this.isFishing = false;
		this.isSeperate = false;
		this.isBar = false;
		this.isOwnerLivesThere = false;
		this.isNoKid = false;
		this.distBalaton = 0d;
		this.distBudapest = 0d;
		this.distBus = 0d;
		this.distCitycenter = 0d;
		this.distGym = 0d;
		this.distHypermarker = 0d;
		this.distPub = 0d;
		this.distRail = 0d;
		this.distRestaurant = 0d;
		this.distSightseeingProgram1 = 0d;
		this.distSightseeingProgram2 = 0d;
		this.distSightseeingProgram3 = 0d;
		this.distSportOpportunity = 0d;
		this.nameSightseeingProgram1 = "";
		this.nameSightseeingProgram2 = "";
		this.nameSightseeingProgram3 = "";
		this.isNorth = false;
		this.numberOfPeople = 0;
		this.numberOfRooms = 0;
		this.numberOfBeds= 0;
		this.image1="";
		this.image2="";
		this.image3="";
		this.image4="";
		this.image5="";
		this.image6="";
		this.image7="";
		this.image8="";
		this.image9="";
		this.image10="";
		this.price=0d;
		
	}

	public Long getApartmanId() {
		return apartmanId;
	}

	public void setApartmanId(Long apartmanId) {
		this.apartmanId = apartmanId;
	}

	public Boolean getIsSeperate() {
		return isSeperate;
	}

	public void setIsSeperate(Boolean isSeperate) {
		this.isSeperate = isSeperate;
	}

	public Boolean getIsOwnerLivesThere() {
		return isOwnerLivesThere;
	}

	public void setIsOwnerLivesThere(Boolean isOwnerLivesThere) {
		this.isOwnerLivesThere = isOwnerLivesThere;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSportOpportunityType() {
		return SportOpportunityType;
	}

	public void setSportOpportunityType(String sportOpportunityType) {
		SportOpportunityType = sportOpportunityType;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}

	public Double getReviewPoints() {
		return reviewPoints;
	}

	public void setReviewPoints(Double reviewPoints) {
		this.reviewPoints = reviewPoints;
	}

	public Integer getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(Integer parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsPartside() {
		return isPartside;
	}

	public void setIsPartside(Boolean isPartside) {
		this.isPartside = isPartside;
	}

	public Boolean getIsFood() {
		return isFood;
	}

	public void setIsFood(Boolean isFood) {
		this.isFood = isFood;
	}

	public Boolean getIsAnimalFriendly() {
		return isAnimalFriendly;
	}

	public void setIsAnimalFriendly(Boolean isAnimalFriendly) {
		this.isAnimalFriendly = isAnimalFriendly;
	}

	public Boolean getIsSauna() {
		return isSauna;
	}

	public void setIsSauna(Boolean isSauna) {
		this.isSauna = isSauna;
	}

	public Boolean getIsPool() {
		return isPool;
	}

	public void setIsPool(Boolean isPool) {
		this.isPool = isPool;
	}

	public Boolean getIsParking() {
		return isParking;
	}

	public void setIsParking(Boolean isParking) {
		this.isParking = isParking;
	}

	public Boolean getIsTrambulin() {
		return isTrambulin;
	}

	public void setIsTrambulin(Boolean isTrambulin) {
		this.isTrambulin = isTrambulin;
	}

	public Boolean getIsPier() {
		return isPier;
	}

	public void setIsPier(Boolean isPier) {
		this.isPier = isPier;
	}

	public Boolean getIsTabbleTennis() {
		return isTabbleTennis;
	}

	public void setIsTabbleTennis(Boolean isTabbleTennis) {
		this.isTabbleTennis = isTabbleTennis;
	}

	public Boolean getIsBilliard() {
		return isBilliard;
	}

	public void setIsBilliard(Boolean isBilliard) {
		this.isBilliard = isBilliard;
	}

	public Boolean getIsTennis() {
		return isTennis;
	}

	public void setIsTennis(Boolean isTennis) {
		this.isTennis = isTennis;
	}

	public Boolean getIsFreeWifi() {
		return isFreeWifi;
	}

	public void setIsFreeWifi(Boolean isFreeWifi) {
		this.isFreeWifi = isFreeWifi;
	}

	public Boolean getIsAirCondition() {
		return isAirCondition;
	}

	public void setIsAirCondition(Boolean isAirCondition) {
		this.isAirCondition = isAirCondition;
	}

	public Boolean getIsJacuzzi() {
		return isJacuzzi;
	}

	public void setIsJacuzzi(Boolean isJacuzzi) {
		this.isJacuzzi = isJacuzzi;
	}

	public Boolean getIsMassage() {
		return isMassage;
	}

	public void setIsMassage(Boolean isMassage) {
		this.isMassage = isMassage;
	}

	public Boolean getIsKidFriendly() {
		return isKidFriendly;
	}

	public void setIsKidFriendly(Boolean isKidFriendly) {
		this.isKidFriendly = isKidFriendly;
	}

	public Boolean getIsPlayground() {
		return isPlayground;
	}

	public void setIsPlayground(Boolean isPlayground) {
		this.isPlayground = isPlayground;
	}

	public Boolean getIsUniversallyAccessable() {
		return isUniversallyAccessable;
	}

	public void setIsUniversallyAccessable(Boolean isUniversallyAccessable) {
		this.isUniversallyAccessable = isUniversallyAccessable;
	}

	public Boolean getIsSmoking() {
		return isSmoking;
	}

	public void setIsSmoking(Boolean isSmoking) {
		this.isSmoking = isSmoking;
	}

	public Boolean getIsHungarian() {
		return isHungarian;
	}

	public void setIsHungarian(Boolean isHungarian) {
		this.isHungarian = isHungarian;
	}

	public Boolean getIsEnglisch() {
		return isEnglisch;
	}

	public void setIsEnglisch(Boolean isEnglisch) {
		this.isEnglisch = isEnglisch;
	}

	public Boolean getIsGerman() {
		return isGerman;
	}

	public void setIsGerman(Boolean isGerman) {
		this.isGerman = isGerman;
	}

	public Boolean getIsOtherLanguage() {
		return isOtherLanguage;
	}

	public void setIsOtherLanguage(Boolean isOtherLanguage) {
		this.isOtherLanguage = isOtherLanguage;
	}

	public Boolean getIsHorseRiding() {
		return isHorseRiding;
	}

	public void setIsHorseRiding(Boolean isHorseRiding) {
		this.isHorseRiding = isHorseRiding;
	}

	public Boolean getIsSurf() {
		return isSurf;
	}

	public void setIsSurf(Boolean isSurf) {
		this.isSurf = isSurf;
	}

	public Boolean getIsFishing() {
		return isFishing;
	}

	public void setIsFishing(Boolean isFishing) {
		this.isFishing = isFishing;
	}

	public Boolean getIsBar() {
		return isBar;
	}

	public void setIsBar(Boolean isBar) {
		this.isBar = isBar;
	}

	public Boolean getIsNoKid() {
		return isNoKid;
	}

	public void setIsNoKid(Boolean isNoKid) {
		this.isNoKid = isNoKid;
	}

	public Double getDistBalaton() {
		return distBalaton;
	}

	public void setDistBalaton(Double distBalaton) {
		this.distBalaton = distBalaton;
	}

	public Double getDistRail() {
		return distRail;
	}

	public void setDistRail(Double distRail) {
		this.distRail = distRail;
	}

	public Double getDistBus() {
		return distBus;
	}

	public void setDistBus(Double distBus) {
		this.distBus = distBus;
	}

	public Double getDistRestaurant() {
		return distRestaurant;
	}

	public void setDistRestaurant(Double distRestaurant) {
		this.distRestaurant = distRestaurant;
	}

	public Double getDistCitycenter() {
		return distCitycenter;
	}

	public void setDistCitycenter(Double distCitycenter) {
		this.distCitycenter = distCitycenter;
	}

	public Double getDistBudapest() {
		return distBudapest;
	}

	public void setDistBudapest(Double distBudapest) {
		this.distBudapest = distBudapest;
	}

	public Double getDistSportOpportunity() {
		return distSportOpportunity;
	}

	public void setDistSportOpportunity(Double distSportOpportunity) {
		this.distSportOpportunity = distSportOpportunity;
	}

	public Double getDistPub() {
		return distPub;
	}

	public void setDistPub(Double distPub) {
		this.distPub = distPub;
	}

	public Double getDistGym() {
		return distGym;
	}

	public void setDistGym(Double distGym) {
		this.distGym = distGym;
	}

	public Double getDistHypermarker() {
		return distHypermarker;
	}

	public void setDistHypermarker(Double distHypermarker) {
		this.distHypermarker = distHypermarker;
	}

	public Double getDistSightseeingProgram1() {
		return distSightseeingProgram1;
	}

	public void setDistSightseeingProgram1(Double distSightseeingProgram1) {
		this.distSightseeingProgram1 = distSightseeingProgram1;
	}

	public Double getDistSightseeingProgram2() {
		return distSightseeingProgram2;
	}

	public void setDistSightseeingProgram2(Double distSightseeingProgram2) {
		this.distSightseeingProgram2 = distSightseeingProgram2;
	}

	public Double getDistSightseeingProgram3() {
		return distSightseeingProgram3;
	}

	public void setDistSightseeingProgram3(Double distSightseeingProgram3) {
		this.distSightseeingProgram3 = distSightseeingProgram3;
	}

	public String getNameSightseeingProgram1() {
		return nameSightseeingProgram1;
	}

	public void setNameSightseeingProgram1(String nameSightseeingProgram1) {
		this.nameSightseeingProgram1 = nameSightseeingProgram1;
	}

	public String getNameSightseeingProgram2() {
		return nameSightseeingProgram2;
	}

	public void setNameSightseeingProgram2(String nameSightseeingProgram2) {
		this.nameSightseeingProgram2 = nameSightseeingProgram2;
	}

	public String getNameSightseeingProgram3() {
		return nameSightseeingProgram3;
	}

	public void setNameSightseeingProgram3(String nameSightseeingProgram3) {
		this.nameSightseeingProgram3 = nameSightseeingProgram3;
	}

	public Date getRentingFrom() {
		return rentingFrom;
	}

	public void setRentingFrom(Date rentingFrom) {
		this.rentingFrom = rentingFrom;
	}

	public Date getRentingTo() {
		return rentingTo;
	}

	public void setRentingTo(Date rentingTo) {
		this.rentingTo = rentingTo;
	}

	

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	public String getImage7() {
		return image7;
	}

	public void setImage7(String image7) {
		this.image7 = image7;
	}

	public String getImage8() {
		return image8;
	}

	public void setImage8(String image8) {
		this.image8 = image8;
	}

	public String getImage9() {
		return image9;
	}

	public void setImage9(String image9) {
		this.image9 = image9;
	}

	public String getImage10() {
		return image10;
	}

	public void setImage10(String image10) {
		this.image10 = image10;
	}
	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		//String base64Image = (image1 != null) ? Base64.getEncoder().encodeToString(image1) : "";
	    return "Apartman[id=" + apartmanId + ", name=" + name + ", description=" + Description + "immage1= "+image1;
	}


}
