package movierental;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getRentalPrice() {

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return getRegularRentalPrice(getDaysRented());

            case Movie.NEW_RELEASE:
                return getRentalPriceForNewRelease(getDaysRented());

            case Movie.CHILDREN:
                return getRentalPriceForChildren(getDaysRented());

            default:
                return 0;
        }
    }

    private double getRentalPriceForChildren(int daysRented) {
        double rentalPrice = 1.5;

        if (daysRented > 3)
            rentalPrice += (daysRented - 3) * 1.5;

        return rentalPrice;
    }

    private int getRentalPriceForNewRelease(int daysRented) {
        return daysRented * 3;
    }

    private double getRegularRentalPrice(int daysRented) {
        double rentalPrice = 2;
        if (daysRented > 2)
            rentalPrice += (daysRented - 2) * 1.5;
        return rentalPrice;
    }

    int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
