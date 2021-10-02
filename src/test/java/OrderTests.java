import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderTests {
    @Test
    public void orderWith1Small1MediumComputesTotalCostOf11(){
        Parcel p1 = new Parcel(9.0, 1);
        Parcel p2 = new Parcel(10.0, 1);

        ArrayList<Parcel> parcels = new ArrayList<>();

        parcels.add(p1);
        parcels.add(p2);

        Order order = new Order(parcels, ItemType.REGULAR_DELIVERY);

        assertEquals(order.getTotalCost(), 11.0, 0.001);
    }

    @Test
    public void orderWith1Small1HeavyNoExtraCostComputesTotalCostOf53(){
        Parcel p1 = new Parcel(9.0, 1);
        Parcel p2 = new Parcel(10.0, 11);

        ArrayList<Parcel> parcels = new ArrayList<>();

        parcels.add(p1);
        parcels.add(p2);

        Order order = new Order(parcels, ItemType.REGULAR_DELIVERY);

        assertEquals(order.getTotalCost(), 53, 0.001);
    }

    @Test
    public void orderWith1Small1HeavyNoExtraCostWithSpeedyShippingComputesTotalCostOf106(){
        Parcel p1 = new Parcel(9.0, 1);
        Parcel p2 = new Parcel(10.0, 11);

        ArrayList<Parcel> parcels = new ArrayList<>();

        parcels.add(p1);
        parcels.add(p2);

        Order order = new Order(parcels, ItemType.SPEEDY_DELIVERY);

        assertEquals(order.getTotalCost(), 106, 0.001);
    }
}
