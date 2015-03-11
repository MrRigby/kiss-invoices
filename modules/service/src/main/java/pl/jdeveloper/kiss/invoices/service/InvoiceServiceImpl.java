package pl.jdeveloper.kiss.invoices.service;

import com.github.lukaszkalek.kissinvoices.model.Invoice;
import com.github.lukaszkalek.kissinvoices.repository.InvoiceRepository;
import com.google.common.base.Preconditions;

public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    
    @Override
    public Invoice invoiceFor(Long id) {
        Preconditions.checkNotNull(id, "Invoice ID cannot be null");
        Preconditions.checkArgument(id > 0, "Invoice being searched has to be greater than zero");
        return invoiceRepository.get(id);
    }
}
