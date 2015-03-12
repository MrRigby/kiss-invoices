package com.github.lukaszkalek.kissinvoices.service;

import com.github.lukaszkalek.kissinvoices.model.Invoice;

public interface InvoiceService {

	Invoice invoiceFor(Long id);
	
}
