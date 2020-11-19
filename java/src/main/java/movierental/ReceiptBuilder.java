package movierental;

public class ReceiptBuilder {

    private final StringBuilder stringBuilder;

    public ReceiptBuilder() {
        stringBuilder = new StringBuilder();
    }

    void addCustomerName(String name) {
        stringBuilder.append("Rental Record for " + name + "\n");
    }

     void addFrequentRentalPoints(int frequentRenterPoints) {
         stringBuilder.append("You earned " + frequentRenterPoints + " frequent renter points");
    }

     void addTotalPrice(double totalPrice) {
         stringBuilder.append("Amount owed is " + totalPrice + "\n");
    }

     void addRentalPrice(double rentalPrice, String title) {
         stringBuilder.append( "\t" + title + "\t" + rentalPrice + "\n");
    }

    String build() {
         return stringBuilder.toString();
    }
}
