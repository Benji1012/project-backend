package szakdoga.Balatoni_szallas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long reviewId;
	@Column(nullable = false)
	private Long apartmanId;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private String reviewComment;
	@Column(nullable = false)
	private Integer reviewPoint;
	
	public Review() {
		this.reviewComment = "";
		this.reviewPoint = 0;
	}
	
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public Long getApartmanId() {
		return apartmanId;
	}
	public void setApartmanId(Long apartmanId) {
		this.apartmanId = apartmanId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public Integer getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(Integer reviewPoint) {
		this.reviewPoint = reviewPoint;
	}
	
	
}
