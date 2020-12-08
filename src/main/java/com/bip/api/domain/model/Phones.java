package com.bip.api.domain.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Phones {


	 private String main;
	 private String secondary;

	@NotEmpty(message = "É obrigatório o preenchimento do telefone.")
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getSecondary() {
		return secondary;
	}
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	

	 
}
