package com.github.lukaszkalek.kissinvoices.rest.domain;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lukaszkalek.kissinvoices.model.Invoice;

public class InvoiceResource extends ResourceSupport {

	private final Invoice invoice;

	@JsonCreator
	public InvoiceResource(@JsonProperty("invoice") Invoice invoice) {
		this.invoice = invoice;
	}

	public Invoice getInvoice() {
		return invoice;
	}
}
