import java.util.Scanner;
import java.util.HashMap;

public class SwiftRouteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Shipment> hashMap = new HashMap<>();

        while (hashMap.size() < 5) {
            System.out.println(" == Shipment Entry Menu ==");
            System.out.println("Choose Shipment Type\n 1.Standard\n 2.Express\n 3.International");
            int ans = sc.nextInt();
            sc.nextLine();
            System.out.print("Please enter tracking number: ");
            String trackingNo = sc.nextLine();
            System.out.print("Please enter content type: ");
            String contentType = sc.nextLine();
            System.out.print("Please enter weight: ");
            int weightKg = sc.nextInt();
            System.out.print("Please enter distance: ");
            int distanceKm = sc.nextInt();

            Shipment shipment = null;
            if (ans == 1) {
                shipment = new StandardShipping(trackingNo, contentType, weightKg, distanceKm);
            } else if (ans == 2) {
                shipment = new ExpressShipping(trackingNo, contentType, weightKg, distanceKm);
            } else if (ans == 3) {
                shipment = new InternationalShipping(trackingNo, contentType, weightKg, distanceKm);
            }

            if (shipment != null) {
                hashMap.put(trackingNo + contentType, shipment);
            }
        }

        System.out.println("\nPrinting All Receipts");
        for (Shipment s : hashMap.values()) {
            s.printReceipt();
        }
    }
}

class Shipment {
    private String trackingNo;
    private String contentType;
    private int weightKg;
    private int distanceKm;

    public Shipment(String trackingNo, String contentType, int weightKg, int distanceKm) {
        this.trackingNo = trackingNo;
        this.contentType = contentType;
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public String getContentType() {
        return contentType;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public double calculateFee() {
        return 0.0;
    }

    public void printReceipt() {
        System.out.println();
        System.out.println("Tracking Number: " + trackingNo);
        System.out.println("Content Type: " + contentType);
        System.out.println("Weight: " + weightKg + "kg, Distance: " + distanceKm + "km");
        System.out.println("Total: " + calculateFee());
    }
}

class StandardShipping extends Shipment {
    public StandardShipping(String t, String c, int w, int d) {
        super(t, c, w, d);
    }

    @Override
    public double calculateFee() {
        return 15.0 + 0.08 * getDistanceKm() + 1.5 * getWeightKg();
    }
}

class ExpressShipping extends Shipment {
    public ExpressShipping(String t, String c, int w, int d) {
        super(t, c, w, d);
    }

    @Override
    public double calculateFee() {
        return 20.0 + 25.0 + 0.12 * getDistanceKm() + 2.2 * getWeightKg();
    }
}

class InternationalShipping extends Shipment {
    public InternationalShipping(String t, String c, int w, int d) {
        super(t, c, w, d);
    }

    @Override
    public double calculateFee() {
        double fee = 30.0 + 40.0 + 0.15 * getDistanceKm() + 3.0 * getWeightKg();
        if (getDistanceKm() > 800) {
            fee += 35.0;
        }
        return fee;
    }
}
