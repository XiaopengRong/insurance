package com.management.claim.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "insurance_claim_management")
public class Claim {
	/** primary key	*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

	@Column(name = "policy_number")
    private String policyNumber;

	@Column(name = "status")
    private String status;
	
	@OneToMany(mappedBy="claim")
	private List<FileEntity> fileEntityList;

//    public Claim() {
//	}
//    
//	public Claim(String firstName, String lastName, Double amount, String email, int phoneNumber, String policyNumber, String status) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.amount = amount;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.policyNumber = policyNumber;
//		this.status = status;
//	}
//	
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public Double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public int getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(int phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getPolicyNumber() {
//		return policyNumber;
//	}
//
//	public void setPolicyNumber(String policyNumber) {
//		this.policyNumber = policyNumber;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public Long getId() {
//		return id;
//	}


}
