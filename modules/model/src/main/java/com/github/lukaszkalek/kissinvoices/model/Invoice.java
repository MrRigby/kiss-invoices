package com.github.lukaszkalek.kissinvoices.model;

import java.util.List;
import java.util.Optional;

/**
 * A model class responsible for holding the data of single invoice. Each
 * invoice is related to one purchaser and consists of at least one position.
 * 
 * @author lukasz
 *
 */
public class Invoice {

	private Optional<Long> id;
	private String number;
	private Purchaser purchaser;
	private List<InvoicePosition> positions;

	public Optional<Long> getId() {
		return id;
	}

	public Invoice withId(Optional<Long> id) {
		this.id = id;
		return this;
	}

	public String getNumber() {
		return number;
	}

	public Invoice withNumber(String number) {
		this.number = number;
		return this;
	}

	public Purchaser getPurchaser() {
		return purchaser;
	}

	public Invoice withPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
		return this;
	}

	public List<InvoicePosition> getPositions() {
		return positions;
	}

	public Invoice withPositions(List<InvoicePosition> positions) {
		this.positions = positions;
		return this;
	}
}
