package szakdoga.Balatoni_szallas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import szakdoga.Balatoni_szallas.dto.ApartmanRequest;
import szakdoga.Balatoni_szallas.model.Apartman;
import szakdoga.Balatoni_szallas.model.Reservation;
import szakdoga.Balatoni_szallas.repository.ApartmanRepository;
import szakdoga.Balatoni_szallas.repository.ReservationRepository;


@RestController
@RequestMapping("/api/apartments")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
@RequiredArgsConstructor
public class ApartmanController {
	@Autowired
	private final ApartmanRepository apartmanRepository;
	@Autowired
	private final ReservationRepository reservationRepository;
	
	
	@Autowired
    private EntityManager entityManager;
	
	@PostMapping("/filtered")
	public ResponseEntity<List<Apartman>> filterApartments(@RequestBody ApartmanRequest filterRequest) {
		System.out.println("filterRequest: "+filterRequest.toString());
		 String name = filterRequest.getName();
		 String city=filterRequest.getCity();
		 Integer type=filterRequest.getType();
		 Double stars=filterRequest.getStars();
		 Double reviewPoints=filterRequest.getReviewPoints();
		 Integer parkingSlots=filterRequest.getParkingSlots();
		 Integer numberOfRoomsMin=filterRequest.getNumberOfRoomsMin();
		 Integer numberOfRoomsMax=filterRequest.getNumberOfRoomsMax();
		 Integer numberOfPeopleMin=filterRequest.getNumberOfPeopleMin();
		 Integer numberOfPeopleMax=filterRequest.getNumberOfPeopleMax();
		 Integer numberOfBedsMin=filterRequest.getNumberOfBedsMin();
		 Integer numberOfBedsMax=filterRequest.getNumberOfBedsMax();
		 Boolean isPartside=filterRequest.getIsPartside();
		 Boolean isFood=filterRequest.getIsFood();
		 Boolean isAnimalFriendly=filterRequest.getIsAnimalFriendly();
		 Boolean isSauna=filterRequest.getIsSauna();
		 Boolean isPool=filterRequest.getIsPool();
		 Boolean isParking=filterRequest.getIsParking();
		 Boolean isTrambulin=filterRequest.getIsTrambulin();
		 Boolean isPier=filterRequest.getIsPier();
		 Boolean isTabbleTennis=filterRequest.getIsTabbleTennis();
		 Boolean isBilliard=filterRequest.getIsBilliard();
		 Boolean isTennis=filterRequest.getIsTennis();
		 Boolean isFreeWifi=filterRequest.getIsFreeWifi();
		 Boolean isAirCondition=filterRequest.getIsAirCondition();
		 Boolean isJacuzzi=filterRequest.getIsJacuzzi();
		 Boolean isMassage=filterRequest.getIsMassage();
		 Boolean isKidFriendly=filterRequest.getIsKidFriendly();
		 Boolean isPlayground=filterRequest.getIsPlayground();
		 Boolean isUniversallyAccessable=filterRequest.getIsUniversallyAccessable();
		 Boolean isSmoking=filterRequest.getIsSmoking();
		 Boolean isHungarian=filterRequest.getIsHungarian();
		 Boolean isEnglisch=filterRequest.getIsEnglisch();
		 Boolean isGerman=filterRequest.getIsGerman();
		 Boolean isHorseRiding=filterRequest.getIsHorseRiding();
		 Boolean isSurf=filterRequest.getIsSurf();
		 Boolean isFishing=filterRequest.getIsFishing();
		 Boolean isBar=filterRequest.getIsBar();
		 Boolean isSeperate=filterRequest.getIsSeperate();
		 Boolean isOwnerLivesThere=filterRequest.getIsOwnerLivesThere();
		 Boolean isNoKid=filterRequest.getIsNoKid();
		 Boolean isNorth=filterRequest.getIsNorth();
		 Boolean isSouth=filterRequest.getIsSouth();
		 Boolean isImage=filterRequest.getIsImage();
		 Boolean isMobile=filterRequest.getIsMobile();
		 Boolean isWebsite=filterRequest.getIsWebsite();

		 Double distBalaton=filterRequest.getDistBalaton();
		 Double distRail=filterRequest.getDistRail();
		 Double distBus=filterRequest.getDistBus();
		 Double distRestaurant=filterRequest.getDistRestaurant();
		 Double distCitycenter=filterRequest.getDistCitycenter();
		 Double distBudapest=filterRequest.getDistBudapest();
		 Double distPub=filterRequest.getDistPub();
		 Double distGym=filterRequest.getDistGym();
		 Double distHypermarker=filterRequest.getDistHypermarker();
		 Date rentingFrom=filterRequest.getRentingFrom();
		 Date rentingTo=filterRequest.getRentingTo();
		 Double priceMin=filterRequest.getPriceMin();
		 Double priceMax=filterRequest.getPriceMax();
		 
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Apartman> query = cb.createQuery(Apartman.class);
	        Root<Apartman> apartmanRoot = query.from(Apartman.class);

	        List<Predicate> predicates = new ArrayList<>();

	        if (name != null && name!= "") {
	            predicates.add(cb.like(apartmanRoot.get("name"), "%" + name + "%"));
	        }
	        if (city != null && city!= "") {
	            predicates.add(cb.like(apartmanRoot.get("city"), "%" + city + "%"));
	        }
	        if (type != null && type!= -1) {
	            predicates.add(cb.equal(apartmanRoot.get("type"),  type ));
	        }
	        if (reviewPoints != null && reviewPoints !=0) {
	            predicates.add(cb.greaterThanOrEqualTo(apartmanRoot.get("reviewPoints"),  reviewPoints ));
	        }
	        if (parkingSlots != null && parkingSlots!= 0) {
	            predicates.add(cb.greaterThanOrEqualTo(apartmanRoot.get("parkingSlots"),  parkingSlots ));
	        }
	        if (numberOfRoomsMin != null && numberOfRoomsMin!= 0) {
	        	predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("numberOfRooms"), numberOfRoomsMin)
	            );
	        }
	        
	        if ( numberOfRoomsMax != null && numberOfRoomsMax!= 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("numberOfRooms"), numberOfRoomsMax)
	            );
	        }
	        
	        if ( numberOfPeopleMax != null && numberOfPeopleMax!= 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("numberOfPeople"), numberOfPeopleMax)
	            );
	        }
	        if (numberOfPeopleMin != null && numberOfPeopleMin!= 0) {
	        	predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("numberOfPeople"), numberOfPeopleMin)
	            );
	        }
	        if ( numberOfBedsMax != null && numberOfBedsMax!= 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("numberOfBeds"), numberOfBedsMax)
	            );
	        }
	        if (numberOfBedsMin != null && numberOfBedsMin!= 0) {
	        	predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("numberOfBeds"), numberOfBedsMin)
	            );
	        }
	        if (isPartside != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isPartside"),  isPartside ));
	        }
	        if (isFood != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isFood"),  isFood ));
	        }
	        if (isAnimalFriendly != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isAnimalFriendly"),  isAnimalFriendly ));
	        }
	        if (isSauna != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isSauna"),  isSauna ));
	        }
	        if (isPool != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isPool"),  isPool ));
	        }
	        if (isPier != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isPier"),  isPier ));
	        }
	        if (isTabbleTennis != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isTabbleTennis"),  isTabbleTennis ));
	        }
	        if (isBilliard != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isBilliard"),  isBilliard ));
	        }
	        if (isTennis != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isTennis"),  isTennis ));
	        }
	        if (isFreeWifi != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isFreeWifi"),  isFreeWifi ));
	        }
	        if (isAirCondition != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isAirCondition"),  isAirCondition ));
	        }
	        if (isJacuzzi != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isJacuzzi"),  isJacuzzi ));
	        }
	        if (isMassage != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isMassage"),  isMassage ));
	        }
	        if (isKidFriendly != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isKidFriendly"),  isKidFriendly ));
	        }
	        if (isPlayground != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isPlayground"),  isPlayground ));
	        }
	        if (isUniversallyAccessable != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isUniversallyAccessable"),  isUniversallyAccessable ));
	        }
	        if (isSmoking != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isSmoking"),  isSmoking ));
	        }
	        if (isHungarian != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isHungarian"),  isHungarian ));
	        }
	        if (isEnglisch != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isEnglisch"),  isEnglisch ));
	        }
	        if (isGerman != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isGerman"),  isGerman ));
	        }
	        if (isHorseRiding != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isHorseRiding"),  isHorseRiding ));
	        }
	        if (isSurf != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isSurf"),  isSurf ));
	        }
	        if (isTrambulin != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isTrambulin"),  isTrambulin ));
	        }
	        if (isFishing != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isFishing"),  isFishing ));
	        }
	        if (isBar != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isBar"),  isBar ));
	        }
	        if (isSeperate != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isSeperate"),  isSeperate ));
	        }
	        if (isOwnerLivesThere != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isOwnerLivesThere"),  isOwnerLivesThere ));
	        }
	        if (isNoKid != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isNoKid"),  isNoKid ));
	        }
	        if (isNorth != null) {
	            predicates.add(cb.equal(apartmanRoot.get("isNorth"),  isNorth ));
	        }
	        if (isSouth != null) {
	            predicates.add(cb.notEqual(apartmanRoot.get("isNorth"),  isSouth ));
	        }
	        if (isImage != null && isImage) {
	            predicates.add(
	                cb.isNotNull(apartmanRoot.get("image1"))
	                );
	        }
	        if (isMobile != null && isMobile) {
	            predicates.add(
	                cb.isNotNull(apartmanRoot.get("mobile")));
	        }
	        
	        if (isWebsite != null && isWebsite) {
	            predicates.add(
	                cb.isNotNull(apartmanRoot.get("website")));
	        }
	        if (distBalaton != null && distBalaton != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distBalaton"), distBalaton)
	            );
	        }
	        if (distRail != null && distRail != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distRail"), distRail)
	            );
	        }
	        if (distBus != null && distBus != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distBus"), distBus)
	            );
	        }
	        if (distRestaurant != null && distRestaurant != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distRestaurant"), distRestaurant)
	            );
	        }
	        if (distCitycenter != null && distCitycenter != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distCitycenter"), distCitycenter)
	            );
	        }
	        if (isParking != null && isParking) {
	            predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("parkingSlots"), 0));
	        }
	        if (distBudapest != null && distBudapest != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distBudapest"), distBudapest)
	            );
	        }
	        if (distPub != null && distPub != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distPub"), distPub)
	            );
	        }
	        if (distGym != null && distGym != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distGym"), distGym)
	            );
	        }
	        if (distHypermarker != null && distHypermarker != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("distHypermarker"), distHypermarker)
	            );
	        }
	        
	        if (stars != null && stars != 0) {
	        	predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("stars"), stars)
	            );
	        }
	        if (rentingFrom != null && rentingTo != null) {
	        	predicates.add(cb.and(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("rentingTo"), rentingFrom),
	                cb.lessThanOrEqualTo(apartmanRoot.get("rentingFrom"), rentingFrom)
	            ));
	        	predicates.add(cb.and(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("rentingTo"), rentingTo),
	                cb.lessThanOrEqualTo(apartmanRoot.get("rentingFrom"), rentingTo)
	            ));
	           
	        }
	        if (priceMin != null && priceMin != 0) {
	        	predicates.add(
	                cb.greaterThanOrEqualTo(apartmanRoot.get("price"), priceMin)
	            );
	        }
	        if (priceMax != null && priceMax != 0) {
	        	predicates.add(
	                cb.lessThanOrEqualTo(apartmanRoot.get("price"), priceMax)
	            );
	        }
	        
	        query.where(predicates.toArray(new Predicate[0]));

	        List<Apartman> filteredApartmans = entityManager.createQuery(query).getResultList();
	        
	        List<Apartman> finalApartments = new ArrayList<>();
	        for (Apartman apartment : filteredApartmans) {
	            if (!hasOverlappingReservations(apartment, rentingFrom, rentingTo)) {
	                finalApartments.add(apartment);
	            }
	        }

		    if (finalApartments.isEmpty()) {
		        return ResponseEntity.ok(null);
		    } else {
		        return ResponseEntity.ok(finalApartments);
		    }
		}
	
	private boolean hasOverlappingReservations(Apartman apartman, Date rentingFrom, Date rentingTo) {
	    List<Reservation> reservations = reservationRepository.findByApartman(apartman);

	    for (Reservation reservation : reservations) {
	        Date resFrom = reservation.getResFrom();
	        Date resTo = reservation.getResTo();

	        if ((rentingFrom.compareTo(resTo) < 0 && rentingTo.compareTo(resFrom) > 0) ||
	            (resFrom.compareTo(rentingTo) < 0 && resTo.compareTo(rentingFrom) > 0) ||
	            (resFrom.compareTo(rentingFrom) >= 0 && resTo.compareTo(rentingTo) <= 0)) {
	            return true;
	        }
	    }
	    return false;
	}

	@GetMapping("/{ownerId}")
	ResponseEntity<List<Apartman>> getApartmansByOwnerId(@PathVariable Long ownerId){
		List<Apartman> apartmans = apartmanRepository.findByOwnerId(ownerId);
		if(apartmans.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(apartmans);
	    }
	}
	
	@PutMapping("/new")
	ResponseEntity<Apartman> newApartman(@RequestBody Apartman newApartman){
		apartmanRepository.save(newApartman);
		return ResponseEntity.ok(newApartman);
	}
	
	@PostMapping("/edit/{apartmanId}")
	public ResponseEntity<Apartman> updateApartmanById( @PathVariable Long apartmanId, @RequestBody Apartman updatedApartman) {
		 Optional<Apartman> optionalApartman = apartmanRepository.findById(apartmanId);
		    if (optionalApartman.isPresent()) {
		    	Apartman apartman = optionalApartman.get();
		        apartman.setWebsite(updatedApartman.getWebsite());
		        apartman.setEmail(updatedApartman.getEmail());
		        apartman.setName(updatedApartman.getName());
		        apartman.setCity(updatedApartman.getCity());
		        apartman.setAddress(updatedApartman.getAddress());
		        apartman.setMobile(updatedApartman.getMobile());
		        apartman.setSportOpportunityType(updatedApartman.getSportOpportunityType());
		        apartman.setDistBalaton(updatedApartman.getDistBalaton());
		        apartman.setDistBudapest(updatedApartman.getDistBudapest());
		        apartman.setDistBus(updatedApartman.getDistBus());
		        apartman.setDistCitycenter(updatedApartman.getDistCitycenter());
		        apartman.setDistGym(updatedApartman.getDistGym());
		        apartman.setDistHypermarker(updatedApartman.getDistHypermarker());
		        apartman.setDistPub(updatedApartman.getDistPub());
		        apartman.setDistRail(updatedApartman.getDistRail());
		        apartman.setDistRestaurant(updatedApartman.getDistRestaurant());
		        apartman.setDistSightseeingProgram1(updatedApartman.getDistSightseeingProgram1());
		        apartman.setDistSightseeingProgram2(updatedApartman.getDistSightseeingProgram2());
		        apartman.setDistSightseeingProgram3(updatedApartman.getDistSightseeingProgram3());
		        apartman.setIsAirCondition(updatedApartman.getIsAirCondition());
		        apartman.setIsAnimalFriendly(updatedApartman.getIsAnimalFriendly());
		        apartman.setIsApproved(updatedApartman.getIsApproved());
		        apartman.setIsBilliard(updatedApartman.getIsBilliard());
		        apartman.setIsBar(updatedApartman.getIsBar());
		        apartman.setIsEnglisch(updatedApartman.getIsEnglisch());
		        apartman.setIsFishing(updatedApartman.getIsFishing());
		        apartman.setIsFood(updatedApartman.getIsFood());
		        apartman.setIsFreeWifi(updatedApartman.getIsFreeWifi());
		        apartman.setIsGerman(updatedApartman.getIsGerman());
		        apartman.setIsHorseRiding(updatedApartman.getIsHorseRiding());
		        apartman.setIsHungarian(updatedApartman.getIsHungarian());
		        apartman.setIsJacuzzi(updatedApartman.getIsJacuzzi());
		        apartman.setIsKidFriendly(updatedApartman.getIsKidFriendly());
		        apartman.setIsNoKid(updatedApartman.getIsNoKid());
		        apartman.setIsMassage(updatedApartman.getIsMassage());
		        apartman.setIsOwnerLivesThere(updatedApartman.getIsOwnerLivesThere());
		        apartman.setIsPartside(updatedApartman.getIsPartside());
		        apartman.setIsPier(updatedApartman.getIsPier());
		        apartman.setIsPlayground(updatedApartman.getIsPlayground());
		        apartman.setIsPool(updatedApartman.getIsPool());
		        apartman.setIsSauna(updatedApartman.getIsSauna());
		        apartman.setIsSeperate(updatedApartman.getIsSeperate());
		        apartman.setIsSmoking(updatedApartman.getIsSmoking());
		        apartman.setIsSurf(updatedApartman.getIsSurf());
		        apartman.setIsTabbleTennis(updatedApartman.getIsTabbleTennis());
		        apartman.setIsTennis(updatedApartman.getIsTennis());
		        apartman.setIsTrambulin(updatedApartman.getIsTrambulin());
		        apartman.setIsUniversallyAccessable(updatedApartman.getIsUniversallyAccessable());
		        apartman.setNameSightseeingProgram1(updatedApartman.getNameSightseeingProgram1());
		        apartman.setNameSightseeingProgram2(updatedApartman.getNameSightseeingProgram2());
		        apartman.setNameSightseeingProgram3(updatedApartman.getNameSightseeingProgram3());
		        apartman.setParkingSlots(updatedApartman.getParkingSlots());
		        apartman.setRentingFrom(updatedApartman.getRentingFrom());
		        apartman.setRentingTo(updatedApartman.getRentingTo());
		        apartman.setStars(updatedApartman.getStars());
		        apartman.setType(updatedApartman.getType());
		        apartman.setIsNorth(updatedApartman.getIsNorth());
		        apartman.setDescription(updatedApartman.getDescription());
		        apartman.setNumberOfPeople(updatedApartman.getNumberOfPeople());
		        apartman.setNumberOfRooms(updatedApartman.getNumberOfRooms());
		        apartman.setNumberOfBeds(updatedApartman.getNumberOfBeds());
		        apartman.setPrice(updatedApartman.getPrice());
		        if(!updatedApartman.getImage1().toString().equals("")) {
		        	apartman.setImage1(updatedApartman.getImage1());
		        }
		        if(!updatedApartman.getImage2().toString().equals("")) {
		        apartman.setImage2(updatedApartman.getImage2());
		        }
		        if(!updatedApartman.getImage3().toString().equals("")) {
		        apartman.setImage3(updatedApartman.getImage3());
		        }
		        if(!updatedApartman.getImage4().toString().equals("")) {
		        apartman.setImage4(updatedApartman.getImage4());
		        }
		        if(!updatedApartman.getImage5().toString().equals("")) {
		        apartman.setImage5(updatedApartman.getImage5());
		        }
		        if(!updatedApartman.getImage6().toString().equals("")) {
		        apartman.setImage6(updatedApartman.getImage6());
		        }
		        if(!updatedApartman.getImage7().toString().equals("")) {
		        apartman.setImage7(updatedApartman.getImage7());
		        }
		        if(!updatedApartman.getImage8().toString().equals("")) {
		        apartman.setImage8(updatedApartman.getImage8());
		        }
		        if(!updatedApartman.getImage9().toString().equals("")) {
		        apartman.setImage9(updatedApartman.getImage9());
		        }
		        if(!updatedApartman.getImage10().toString().equals("")) {
		        apartman.setImage10(updatedApartman.getImage10());
		        }
		        //apartman.setNumberOfBeds(updatedApartman.getNumberOfBeds());
		        apartmanRepository.save(apartman);
		        return ResponseEntity.ok(apartman);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
	@GetMapping("/view/{id}")
	 public ResponseEntity<Apartman> getApartmanById( @PathVariable Long id) {
		
		 return apartmanRepository.findById(id)
			        .map(apartman -> {return ResponseEntity.ok(apartman);})
			        .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
			}
	
	@GetMapping("/adview/{id}")
	 public ResponseEntity<Apartman> getAdApartmanById( @PathVariable Long id) {
		
		 return apartmanRepository.findById(id)
			        .map(apartman -> {;return ResponseEntity.ok(apartman);})
			        .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
			}
	
	@PostMapping("/upload-images")
	public ResponseEntity<List<String>> uploadImages(@RequestParam Map<String, MultipartFile> formData) {
	    List<String> imageUrls = new ArrayList<>();
	    for (Map.Entry<String, MultipartFile> entry : formData.entrySet()) {
	        String fileName = UUID.randomUUID().toString();
	        Path imagePath = Paths.get("C:\\Users\\ASUS\\Documents\\szakdogához dolgok\\kepek/", fileName+".jpg");
	        try {
	        	Files.copy(entry.getValue().getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
	            String imageUrl = "http://192.168.1.2:8081/" + fileName+".jpg";
	            imageUrls.add(imageUrl);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	    return ResponseEntity.ok(imageUrls);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity deleteApartmanById( @PathVariable Long id) {
		 apartmanRepository.deleteById(id);
		 if(!apartmanRepository.findById(id).isPresent()) {
			 return ResponseEntity.ok("ok");
		 }else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }
			        
			}

	
}
