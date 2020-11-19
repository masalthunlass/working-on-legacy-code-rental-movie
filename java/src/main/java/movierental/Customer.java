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

    // calcul totalPrice = I :  O :
    // receipt = I :  O :
    // points =  I :  O :
    public String toReceipt() {
        double totalPrice = 0;

        int frequentRenterPoints = 0;
        String receipt = "Rental Record for " + getName() + "\n";
        for (Rental rental: _rentals) {
            double rentalPrice = rental.getRentalPrice();

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            receipt += "\t" + rental.getMovie().getTitle() + "\t" + rentalPrice + "\n";
            totalPrice += rentalPrice;
        }

        // add footer lines
        receipt += "Amount owed is " + totalPrice + "\n";
        receipt += "You earned " + frequentRenterPoints + " frequent renter points";

        return receipt;
    }

}
