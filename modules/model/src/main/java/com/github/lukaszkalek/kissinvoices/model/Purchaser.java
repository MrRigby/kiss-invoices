package com.github.lukaszkalek.kissinvoices.model;

import java.util.Optional;

/**
 * A natural or legal person that did a purchase and has to receive an invoice.
 * 
 * @author lukasz
 *
 */
public class Purchaser {

	private Optional<Long> id;

	private String name;
	private String address;
	private String taxIdentifier;

	public Optional<Long> getId() {
		return id;
	}

	public Purchaser withId(Optional<Long> id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Purchaser withName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Purchaser withAddress(String address) {
		this.address = address;
		return this;
	}

	public String getTaxIdentifier() {
		return taxIdentifier;
	}

	public Purchaser withTaxIdentifier(String taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
		return this;
	}

}
