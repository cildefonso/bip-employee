package com.bip.api.dtos;

import java.util.Date;
import java.util.Optional;

import org.bson.types.ObjectId;

public class LaunchDto {
	
	private ObjectId _id;
	private String inputwork;
	private String outputwork;
	private Double valuehour;
	private Optional<String> typelauch  = Optional.empty();
	private String description;
	private Optional<String> location  = Optional.empty();
	private Date datelaunch;
	

	public LaunchDto() {
	}


	public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}


	public String getInputwork() {
		return inputwork;
	}


	public void setInputwork(String inputwork) {
		this.inputwork = inputwork;
	}


	public String getOutputwork() {
		return outputwork;
	}


	public void setOutputwork(String outputwork) {
		this.outputwork = outputwork;
	}


	public Double getValuehour() {
		return valuehour;
	}


	public void setValuehour(Double valuehour) {
		this.valuehour = valuehour;
	}


	public Optional<String> getTypelauch() {
		return typelauch;
	}


	public void setTypelauch(Optional<String> typelauch) {
		this.typelauch = typelauch;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Optional<String> getLocation() {
		return location;
	}


	public void setLocation(Optional<String> location) {
		this.location = location;
	}


	public Date getDatelaunch() {
		return datelaunch;
	}


	public void setDatelaunch(Date datelaunch) {
		this.datelaunch = datelaunch;
	}


	@Override
	public String toString() {
		return "LaunchDto [_id=" + _id + ", inputwork=" + inputwork + ", outputwork=" + outputwork + ", valuehour="
				+ valuehour + ", typelauch=" + typelauch + ", description=" + description + ", location=" + location
				+ ", datelaunch=" + datelaunch + "]";
	}

	
	
}
