package SOLID.SingleResp;
// Single Responsibility Principle : “Each class has a single reason to change.(one class one purpose)”

// Responsibility only for invoice instantiation
class Invoice{
    int amount;
    Invoice(int amount){
        this.amount = amount;
    }
}

// Responsible only for printing
class InvoicePrinter{
    void print(Invoice invoice){
        System.out.println("Invoice amount : " + invoice.amount);
    }
}

// Responsible only for persistence
class InvoiceRepository{
    void save(Invoice invoice){
        System.out.println("Invoice saved to DB");
    }
}

public class SRP {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        InvoiceRepository repo = new InvoiceRepository();
        repo.save(invoice);
    }
}
