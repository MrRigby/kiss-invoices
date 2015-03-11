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

	public void withId(Optional<Long> id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void withNumber(String number) {
		this.number = number;
	}

	public Purchaser getPurchaser() {
		return purchaser;
	}

	public void withPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

	public List<InvoicePosition> getPositions() {
		return positions;
	}

	public void withPositions(List<InvoicePosition> positions) {
		this.positions = positions;
	}
}
