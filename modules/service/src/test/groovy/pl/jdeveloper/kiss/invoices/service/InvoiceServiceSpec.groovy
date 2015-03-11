package pl.jdeveloper.kiss.invoices.service

import spock.lang.Specification

import com.github.lukaszkalek.kissinvoices.model.Invoice
import com.github.lukaszkalek.kissinvoices.repository.InvoiceRepository

class InvoiceServiceSpec extends Specification {

    def InvoiceRepository invoiceRepository
    def InvoiceService invoiceService

    def setup() {
        invoiceRepository = Mock(InvoiceRepository)
        invoiceService = new InvoiceServiceImpl(invoiceRepository)
    }

    def "Should report precondition exceptions"() {

        when:
        invoiceService.invoiceFor(invoiceId)

        then:
        thrown(expectedException)

        where:
        invoiceId | expectedException
        null      | NullPointerException
        0         | IllegalArgumentException
        -1        | IllegalArgumentException
    }
    
    def "Should query repository for the invoice"() {
        
        given:
        def correctInvoiceId = 1
        def returnedInvoice = new Invoice()
        
        when:
        def invoice = invoiceService.invoiceFor(correctInvoiceId)
        
        then:
        1 * invoiceRepository.get({id -> id == correctInvoiceId}) >> returnedInvoice
        returnedInvoice == invoice
    }
}
