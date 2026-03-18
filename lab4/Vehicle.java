public class Vehicle {
    public static void main(String[] args) {
        Vehicle[] arr = new Vehicle[3];
        arr[0] = new Vehicle("a", 10);
        arr[1] = new Truck("b", 10.0, 30.0);
        arr[2] = new Vehicle("b", 5.0);

        int daysToRent = 5;
        for (Vehicle v : arr) {
            v.safetyCheck();
            v.calculateRental(daysToRent);
            System.out.println();
        }
    }

    String licensePlate;
    double dailyRate;

    public Vehicle(String licensePlate, double dailyRate) {
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
    }

    public boolean checkRisk() {
        return false;
    }

    public double calculateRental(int days) {
        return days * dailyRate;
    }

    public void safetyCheck() {
        System.out.println(licensePlate + " Brakes and lights functional.");
    }
}

class Truck extends Vehicle {
    double cargoCapacity;

    public Truck(String licensePlate, double dailyRate, double cargoCapacity) {
        super(licensePlate, dailyRate);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean checkRisk() {
        return cargoCapacity > 20;
    }

    @Override
    public void safetyCheck() {
        super.safetyCheck();
        if (cargoCapacity < 40) {
            System.out.println(" Capacity " + cargoCapacity + " is within safe limits.");
        } else {
            System.out.println("Capacity exceeds standard safety.");
        }
    }
}

class HeavyDutyTruck extends Truck {
    int axleCount;

    public HeavyDutyTruck(String licensePlate, double dailyRate, double cargoCapacity, int axleCount) {
        super(licensePlate, dailyRate, cargoCapacity);
        this.axleCount = axleCount;
    }

    @Override
    public boolean checkRisk() {
        return axleCount > 4;
    }

    @Override
    public double calculateRental(int days) {
        return super.calculateRental(days) + axleCount;
    }
}
