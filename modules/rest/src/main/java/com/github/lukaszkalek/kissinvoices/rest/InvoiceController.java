package com.github.lukaszkalek.kissinvoices.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.lukaszkalek.kissinvoices.model.Invoice;
import com.github.lukaszkalek.kissinvoices.model.Purchaser;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Invoice getInvoice(@PathVariable("id") Long id) {
		return new Invoice() //
				.withId(Optional.of(1L)) //
				.withNumber("2015/112") //
				.withPurchaser(
						new Purchaser() //
							.withId(Optional.of(2L)) //
							.withName("Zenon Makaron") //
							.withAddress("ul. Jasminowa 1")
				);
	}
}
