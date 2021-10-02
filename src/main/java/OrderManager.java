import java.util.ArrayList;

/**
 * Represents an OrderManager, tasked with parsing inputs and producing outputs.
 * The interface of the application.
 */
public class OrderManager {
    public String placeOrder(InputOrder inputOrder) {
        ArrayList<Parcel> parcels = new ArrayList<>();

        for (InputParcel inputParcel : inputOrder.parcels) {
            parcels.add(new Parcel(inputParcel.getDimensions(), inputParcel.getWeight()));
        }

        return new Order(parcels, inputOrder.deliveryType).toString();
    }
}
