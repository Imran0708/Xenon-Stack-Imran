package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPayNgo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donId;
	private String donName;
	private String donCn;
	private String donCnM;
	private String donCnY;
	private String donCvv;
	private String donPurpose;
	private String donAmt;

	public UserPayNgo() {

	}

	public UserPayNgo(String donName, String donCn, String donCnM, String donCnY, String donCvv, String donPurpose,
			String donAmt) {
		super();
		this.donName = donName;
		this.donCn = donCn;
		this.donCnM = donCnM;
		this.donCnY = donCnY;
		this.donCvv = donCvv;
		this.donPurpose = donPurpose;
		this.donAmt = donAmt;
	}

	public int getDonId() {
		return donId;
	}

	public void setDonId(int donId) {
		this.donId = donId;
	}

	public String getDonName() {
		return donName;
	}

	public void setDonName(String donName) {
		this.donName = donName;
	}

	public String getDonCn() {
		return donCn;
	}

	public void setDonCn(String donCn) {
		this.donCn = donCn;
	}

	public String getDonCnM() {
		return donCnM;
	}

	public void setDonCnM(String donCnM) {
		this.donCnM = donCnM;
	}

	public String getDonCnY() {
		return donCnY;
	}

	public void setDonCnY(String donCnY) {
		this.donCnY = donCnY;
	}

	public String getDonCvv() {
		return donCvv;
	}

	public void setDonCvv(String donCvv) {
		this.donCvv = donCvv;
	}

	public String getDonPurpose() {
		return donPurpose;
	}

	public void setDonPurpose(String donPurpose) {
		this.donPurpose = donPurpose;
	}

	public String getDonAmt() {
		return donAmt;
	}

	public void setDonAmt(String donAmt) {
		this.donAmt = donAmt;
	}


}
