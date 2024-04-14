package szakdoga.Balatoni_szallas.dto;

import java.util.Date;

public class ApartmanRequest {
	
	private String name;
	private String city;
	private Integer type;
	private Double stars;
	private Double reviewPoints;
	private Integer parkingSlots;
	private Integer numberOfRoomsMin;
	private Integer numberOfRoomsMax;
	private Integer numberOfPeopleMin;
	private Integer numberOfPeopleMax;
	private Integer numberOfBedsMin;
	private Integer numberOfBedsMax;
	private Boolean isPartside;
	private Boolean isFood;
	private Boolean isAnimalFriendly;
	private Boolean isSauna;
	private Boolean isPool;
	private Boolean isParking;
	private Boolean isTrambulin;
	private Boolean isPier;
	private Boolean isTabbleTennis;
	private Boolean isBilliard;
	private Boolean isTennis;
	private Boolean isFreeWifi;
	private Boolean isAirCondition;
	private Boolean isJacuzzi;
	private Boolean isMassage;
	private Boolean isKidFriendly;
	private Boolean isPlayground;
	private Boolean isUniversallyAccessable;
	private Boolean isSmoking;
	private Boolean isHungarian;
	private Boolean isEnglisch;
	private Boolean isGerman;
	private Boolean isHorseRiding;
	private Boolean isSurf;
	private Boolean isFishing;
	private Boolean isBar;
	private Boolean isSeperate;
	private Boolean isOwnerLivesThere;
	private Boolean isNoKid;
	private Boolean isNorth;
	private Boolean isSouth;
	private Boolean isImage;
	private Boolean isMobile;
	private Boolean isWebsite;

	private Double distBalaton;
	private Double distRail;
	private Double distBus;
	private Double distRestaurant;
	private Double distCitycenter;
	private Double distBudapest;
	private Double distPub;
	private Double distGym;
	private Double distHypermarker;
	private Date rentingFrom;
	private Date rentingTo;
	private Double priceMin;
	private Double priceMax;
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	public Integer getNumberOfRoomsMin() {
		return numberOfRoomsMin;
	}
	public void setNumberOfRoomsMin(Integer numberOfRoomsMin) {
		this.numberOfRoomsMin = numberOfRoomsMin;
	}
	public Integer getNumberOfRoomsMax() {
		return numberOfRoomsMax;
	}
	public void setNumberOfRoomsMax(Integer numberOfRoomsMax) {
		this.numberOfRoomsMax = numberOfRoomsMax;
	}
	public Integer getNumberOfPeopleMin() {
		return numberOfPeopleMin;
	}
	public void setNumberOfPeopleMin(Integer numberOfPeopleMin) {
		this.numberOfPeopleMin = numberOfPeopleMin;
	}
	public Integer getNumberOfPeopleMax() {
		return numberOfPeopleMax;
	}
	public void setNumberOfPeopleMax(Integer numberOfPeopleMax) {
		this.numberOfPeopleMax = numberOfPeopleMax;
	}
	public Integer getNumberOfBedsMin() {
		return numberOfBedsMin;
	}
	public void setNumberOfBedsMin(Integer numberOfBedsMin) {
		this.numberOfBedsMin = numberOfBedsMin;
	}
	public Integer getNumberOfBedsMax() {
		return numberOfBedsMax;
	}
	public void setNumberOfBedsMax(Integer numberOfBedsMax) {
		this.numberOfBedsMax = numberOfBedsMax;
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
	public Boolean getIsNoKid() {
		return isNoKid;
	}
	public void setIsNoKid(Boolean isNoKid) {
		this.isNoKid = isNoKid;
	}
	public Boolean getIsNorth() {
		return isNorth;
	}
	public void setIsNorth(Boolean isNorth) {
		this.isNorth = isNorth;
	}
	public Boolean getIsSouth() {
		return isSouth;
	}
	public void setIsSouth(Boolean isSouth) {
		this.isSouth = isSouth;
	}
	public Boolean getIsImage() {
		return isImage;
	}
	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}
	public Boolean getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}
	public Boolean getIsWebsite() {
		return isWebsite;
	}
	public void setIsWebsite(Boolean isWebsite) {
		this.isWebsite = isWebsite;
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
	public Double getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}
	public Double getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}
	@Override
	public String toString() {
		return "ApartmanRequest [name=" + name + ", city=" + city + ", type=" + type + ", stars=" + stars
				+ ", reviewPoints=" + reviewPoints + ", parkingSlots=" + parkingSlots + ", numberOfRoomsMin="
				+ numberOfRoomsMin + ", numberOfRoomsMax=" + numberOfRoomsMax + ", numberOfPeopleMin="
				+ numberOfPeopleMin + ", numberOfPeopleMax=" + numberOfPeopleMax + ", numberOfBedsMin="
				+ numberOfBedsMin + ", numberOfBedsMax=" + numberOfBedsMax + ", isPartside=" + isPartside + ", isFood="
				+ isFood + ", isAnimalFriendly=" + isAnimalFriendly + ", isSauna=" + isSauna + ", isPool=" + isPool
				+ ", isParking=" + isParking + ", isTrambulin=" + isTrambulin + ", isPier=" + isPier
				+ ", isTabbleTennis=" + isTabbleTennis + ", isBilliard=" + isBilliard + ", isTennis=" + isTennis
				+ ", isFreeWifi=" + isFreeWifi + ", isAirCondition=" + isAirCondition + ", isJacuzzi=" + isJacuzzi
				+ ", isMassage=" + isMassage + ", isKidFriendly=" + isKidFriendly + ", isPlayground=" + isPlayground
				+ ", isUniversallyAccessable=" + isUniversallyAccessable + ", isSmoking=" + isSmoking + ", isHungarian="
				+ isHungarian + ", isEnglisch=" + isEnglisch + ", isGerman=" + isGerman + ", isHorseRiding="
				+ isHorseRiding + ", isSurf=" + isSurf + ", isFishing=" + isFishing + ", isBar=" + isBar
				+ ", isSeperate=" + isSeperate + ", isOwnerLivesThere=" + isOwnerLivesThere + ", isNoKid=" + isNoKid
				+ ", isNorth=" + isNorth + ", isSouth=" + isSouth + ", isImage=" + isImage + ", isMobile=" + isMobile
				+ ", isWebsite=" + isWebsite + ", distBalaton=" + distBalaton + ", distRail=" + distRail + ", distBus="
				+ distBus + ", distRestaurant=" + distRestaurant + ", distCitycenter=" + distCitycenter
				+ ", distBudapest=" + distBudapest + ", distPub=" + distPub + ", distGym=" + distGym
				+ ", distHypermarker=" + distHypermarker + ", rentingFrom=" + rentingFrom + ", rentingTo=" + rentingTo
				+ ", priceMin=" + priceMin + ", priceMax=" + priceMax + ", getName()=" + getName() + ", getCity()="
				+ getCity() + ", getType()=" + getType() + ", getStars()=" + getStars() + ", getReviewPoints()="
				+ getReviewPoints() + ", getParkingSlots()=" + getParkingSlots() + ", getNumberOfRoomsMin()="
				+ getNumberOfRoomsMin() + ", getNumberOfRoomsMax()=" + getNumberOfRoomsMax()
				+ ", getNumberOfPeopleMin()=" + getNumberOfPeopleMin() + ", getNumberOfPeopleMax()="
				+ getNumberOfPeopleMax() + ", getNumberOfBedsMin()=" + getNumberOfBedsMin() + ", getNumberOfBedsMax()="
				+ getNumberOfBedsMax() + ", getIsPartside()=" + getIsPartside() + ", getIsFood()=" + getIsFood()
				+ ", getIsAnimalFriendly()=" + getIsAnimalFriendly() + ", getIsSauna()=" + getIsSauna()
				+ ", getIsPool()=" + getIsPool() + ", getIsParking()=" + getIsParking() + ", getIsTrambulin()="
				+ getIsTrambulin() + ", getIsPier()=" + getIsPier() + ", getIsTabbleTennis()=" + getIsTabbleTennis()
				+ ", getIsBilliard()=" + getIsBilliard() + ", getIsTennis()=" + getIsTennis() + ", getIsFreeWifi()="
				+ getIsFreeWifi() + ", getIsAirCondition()=" + getIsAirCondition() + ", getIsJacuzzi()="
				+ getIsJacuzzi() + ", getIsMassage()=" + getIsMassage() + ", getIsKidFriendly()=" + getIsKidFriendly()
				+ ", getIsPlayground()=" + getIsPlayground() + ", getIsUniversallyAccessable()="
				+ getIsUniversallyAccessable() + ", getIsSmoking()=" + getIsSmoking() + ", getIsHungarian()="
				+ getIsHungarian() + ", getIsEnglisch()=" + getIsEnglisch() + ", getIsGerman()=" + getIsGerman()
				+ ", getIsHorseRiding()=" + getIsHorseRiding() + ", getIsSurf()=" + getIsSurf() + ", getIsFishing()="
				+ getIsFishing() + ", getIsBar()=" + getIsBar() + ", getIsSeperate()=" + getIsSeperate()
				+ ", getIsOwnerLivesThere()=" + getIsOwnerLivesThere() + ", getIsNoKid()=" + getIsNoKid()
				+ ", getIsNorth()=" + getIsNorth() + ", getIsSouth()=" + getIsSouth() + ", getIsImage()=" + getIsImage()
				+ ", getIsMobile()=" + getIsMobile() + ", getIsWebsite()=" + getIsWebsite() + ", getDistBalaton()="
				+ getDistBalaton() + ", getDistRail()=" + getDistRail() + ", getDistBus()=" + getDistBus()
				+ ", getDistRestaurant()=" + getDistRestaurant() + ", getDistCitycenter()=" + getDistCitycenter()
				+ ", getDistBudapest()=" + getDistBudapest() + ", getDistPub()=" + getDistPub() + ", getDistGym()="
				+ getDistGym() + ", getDistHypermarker()=" + getDistHypermarker() + ", getRentingFrom()="
				+ getRentingFrom() + ", getRentingTo()=" + getRentingTo() + ", getPriceMin()=" + getPriceMin()
				+ ", getPriceMax()=" + getPriceMax() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

   
}
