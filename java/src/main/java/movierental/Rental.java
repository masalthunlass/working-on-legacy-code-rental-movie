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
        double rentalPrice = 0;

        //determine amounts for rental line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (getDaysRented() > 2)
                    rentalPrice += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                rentalPrice += 1.5;
                if (getDaysRented() > 3)
                    rentalPrice += (getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalPrice;
    }

    int getFrequentRenterPoints() {
       int frequentRenterPoints = 1;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
