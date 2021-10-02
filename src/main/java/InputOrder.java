import java.util.List;

/**
 * Temporary input class to facilitate testing.
 */
public class InputOrder {
    List<InputParcel> parcels;
    ItemType deliveryType;

    public InputOrder(List<InputParcel> parcels, ItemType deliveryType) {
        this.parcels = parcels;
        this.deliveryType = deliveryType;
    }

    public List<InputParcel> getParcels() {
        return parcels;
    }

    public ItemType getDeliveryType() {
        return deliveryType;
    }
}
