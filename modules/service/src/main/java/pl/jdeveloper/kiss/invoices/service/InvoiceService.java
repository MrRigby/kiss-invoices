package pl.jdeveloper.kiss.invoices.service;

import com.github.lukaszkalek.kissinvoices.model.Invoice;

public interface InvoiceService {

	Invoice invoiceFor(Long id);
	
}
