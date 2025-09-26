
import java.util.Scanner;

// Abstract class
abstract class Car {

    private final boolean isSedan;
    private final String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public String getIsSedan() {
        return (isSedan ? "Sedan" : "Not Sedan");
    }

    public String getSeats() {
        return seats;
    }

    // Abstract method
    public abstract String getMileage();
}

// WagonR class
class WagonR extends Car {

    private int mileage;

    public WagonR(int mileage) {
        super(false, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

// HondaCity class
class HondaCity extends Car {

    private int mileage;

    public HondaCity(int mileage) {
        super(true, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

// InnovaCrysta class
class InnovaCrysta extends Car {

    private final int mileage;

    public InnovaCrysta(int mileage) {
        super(false, "6");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

public class CarDetails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0 for WagonR, 1 for HondaCity, 2 for InnovaCrysta
        System.out.println("Car choice 0 for WagonR, 1 for HondaCity, 2 for InnovaCrysta: ");
        int choice = sc.nextInt();
        System.out.println("Mileage: ");
        int mileage = sc.nextInt();
        Car car = null;
        switch (choice) {
            case 0 ->
                car = new WagonR(mileage);
            case 1 ->
                car = new HondaCity(mileage);
            case 2 ->
                car = new InnovaCrysta(mileage);
            default -> {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("A " + car.getIsSedan() + " car with " + car.getSeats() + " seats and mileage of " + car.getMileage() + ".");
        sc.close();
    }
}
