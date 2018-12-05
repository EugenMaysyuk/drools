package com.may.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugenMaysyuk on 3/6/2018.
 */
public class Product {

	private String type;
	private int discount;
	private String event;
	private String buyer;
	private List<State> states = new ArrayList<State>();

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
}