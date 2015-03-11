package com.github.lukaszkalek.kissinvoices.repository;

import com.github.lukaszkalek.kissinvoices.model.Invoice;

/**
 * Repository responsible for managing {@link Invoice} classes.
 * 
 * @author Lukasz Kalek <lukasz.kalek@gmail.com>
 *
 */
public interface InvoiceRepository {

    /**
     * Gets invoice for given id.
     * 
     * @param id
     *            identifier of the invoice
     * @return found invoice
     */
    Invoice get(Long id);

    /**
     * Gets invoice for given unique number.
     * 
     * @param number
     *            unique number of the invoice
     * @return found invoice
     */
    Invoice getByNumber(String number);

    /**
     * Creates new invoices in the repository. When the invoice is being
     * created, all the positions will be created as well.
     * 
     * @param invoice
     */
    void create(Invoice invoice);

    /**
     * Updates the invoice in the repository. When the invoice is being updated,
     * all the positions will be updated as well.
     * 
     * @param invoice
     */
    void update(Invoice invoice);
}
