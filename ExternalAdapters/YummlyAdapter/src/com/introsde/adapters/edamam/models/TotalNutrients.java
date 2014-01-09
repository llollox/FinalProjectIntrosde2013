package com.introsde.adapters.edamam.models;

import com.introsde.adapters.edamam.models.nutrients.CHOCDF;
import com.introsde.adapters.edamam.models.nutrients.CHOLE;
import com.introsde.adapters.edamam.models.nutrients.ENERC_KCAL;
import com.introsde.adapters.edamam.models.nutrients.FASAT;
import com.introsde.adapters.edamam.models.nutrients.FAT;
import com.introsde.adapters.edamam.models.nutrients.FATRN;
import com.introsde.adapters.edamam.models.nutrients.FIBTG;
import com.introsde.adapters.edamam.models.nutrients.NA;
import com.introsde.adapters.edamam.models.nutrients.PROCNT;
import com.introsde.adapters.edamam.models.nutrients.SUGAR;

public class TotalNutrients {

	private ENERC_KCAL ENERC_KCAL;

	private FAT FAT;

	private FASAT FASAT;

	private FATRN FATRN;

	private CHOCDF CHOCDF;

	private FIBTG FIBTG;

	private SUGAR SUGAR;

	private PROCNT PROCNT;

	private CHOLE CHOLE;

	private NA NA;

	public ENERC_KCAL getENERC_KCAL() {
		return ENERC_KCAL;
	}

	public void setENERC_KCAL(ENERC_KCAL ENERC_KCAL) {
		this.ENERC_KCAL = ENERC_KCAL;
	}

	public FAT getFAT() {
		return FAT;
	}

	public void setFAT(FAT FAT) {
		this.FAT = FAT;
	}

	public FASAT getFASAT() {
		return FASAT;
	}

	public void setFASAT(FASAT FASAT) {
		this.FASAT = FASAT;
	}

	public FATRN getFATRN() {
		return FATRN;
	}

	public void setFATRN(FATRN FATRN) {
		this.FATRN = FATRN;
	}

	public CHOCDF getCHOCDF() {
		return CHOCDF;
	}

	public void setCHOCDF(CHOCDF CHOCDF) {
		this.CHOCDF = CHOCDF;
	}

	public FIBTG getFIBTG() {
		return FIBTG;
	}

	public void setFIBTG(FIBTG FIBTG) {
		this.FIBTG = FIBTG;
	}

	public SUGAR getSUGAR() {
		return SUGAR;
	}

	public void setSUGAR(SUGAR SUGAR) {
		this.SUGAR = SUGAR;
	}

	public PROCNT getPROCNT() {
		return PROCNT;
	}

	public void setPROCNT(PROCNT PROCNT) {
		this.PROCNT = PROCNT;
	}

	public CHOLE getCHOLE() {
		return CHOLE;
	}

	public void setCHOLE(CHOLE CHOLE) {
		this.CHOLE = CHOLE;
	}

	public NA getNA() {
		return NA;
	}

	public void setNA(NA NA) {
		this.NA = NA;
	}

	@Override
	public String toString() {
		return "\nTotalNutrients [ENERC_KCAL=" + ENERC_KCAL + ", FAT=" + FAT
				+ ", FASAT=" + FASAT + ", FATRN=" + FATRN + ", CHOCDF="
				+ CHOCDF + ", FIBTG=" + FIBTG + ", SUGAR=" + SUGAR
				+ ", PROCNT=" + PROCNT + ", CHOLE=" + CHOLE + ", NA=" + NA
				+ "]";
	}

}
