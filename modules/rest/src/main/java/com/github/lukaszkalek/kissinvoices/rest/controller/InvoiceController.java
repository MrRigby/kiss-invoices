package com.github.lukaszkalek.kissinvoices.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.Optional;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.lukaszkalek.kissinvoices.model.Invoice;
import com.github.lukaszkalek.kissinvoices.model.Purchaser;
import com.github.lukaszkalek.kissinvoices.rest.domain.InvoiceResource;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

//	private final InvoiceService invoiceService;

//	@Autowired
//	public InvoiceController(InvoiceService invoiceService) {
//		this.invoiceService = invoiceService;
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<InvoiceResource> getInvoice(@PathVariable("id") Long id) {
		Invoice invoice = temporarilyMockedInvoice();
		if (invoice != null) {
			InvoiceResource resource = new InvoiceResource(invoice);
			resource.add(linkTo(methodOn(InvoiceController.class).getInvoice(id)).withSelfRel());
			return new ResponseEntity<>(resource, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	private Invoice temporarilyMockedInvoice() {
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
