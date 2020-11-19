package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String _name;
    private final List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    public String toReceipt() {
        double totalPrice = 0;
        final ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        int frequentRenterPoints = 0;
        receiptBuilder.addCustomerName(getName());

        for (Rental rental : _rentals) {
            double rentalPrice = rental.getRentalPrice();

            frequentRenterPoints += rental.getFrequentRenterPoints();

            // show figures for this rental
            receiptBuilder.addRentalPrice(rentalPrice, rental.getMovie().getTitle());
            totalPrice += rentalPrice;
        }

        // add footer lines
        receiptBuilder.addTotalPrice(totalPrice);
        receiptBuilder.addFrequentRentalPoints(frequentRenterPoints);

        return receiptBuilder.build();
    }


}
