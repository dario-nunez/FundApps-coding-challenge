import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderManagerTests {
    @Test
    public void orderContainsAllTheParcelsAndTheirSummedCostNoSpeedyShippingNoDiscount(){
        // Creating actual input
        ArrayList<InputParcel> inputParcels = new ArrayList<>();

        InputParcel small = new InputParcel(9.0, 1);
        InputParcel medium = new InputParcel(49.0, 3);
        InputParcel large = new InputParcel(99.0, 6);
        InputParcel xl = new InputParcel(100.0, 10);

        inputParcels.add(small);
        inputParcels.add(medium);
        inputParcels.add(large);
        inputParcels.add(xl);

        InputOrder inputOrder = new InputOrder(inputParcels, ItemType.REGULAR_DELIVERY);

        OrderManager orderManager = new OrderManager();
        String actualResult = orderManager.placeOrder(inputOrder);

        // Creating expected output
        String expectedOutput = "{\"items\":[{\"cost\":25.0,\"type\":\"XL_PARCEL\"},{\"cost\":15.0,\"type\":\"LARGE_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":3.0,\"type\":\"SMALL_PARCEL\"}],\"totalCost\":51.0}";

        // Comparing input vs output
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderContainsAllTheParcelsAndTheirSummedCostWithSpeedyDelivery(){
        // Creating actual input
        ArrayList<InputParcel> inputParcels = new ArrayList<>();

        InputParcel small = new InputParcel(9.0,1);
        InputParcel medium = new InputParcel(49.0,3);
        InputParcel large = new InputParcel(99.0,6);
        InputParcel xl = new InputParcel(100.0,10);

        inputParcels.add(small);
        inputParcels.add(medium);
        inputParcels.add(large);
        inputParcels.add(xl);

        InputOrder inputOrder = new InputOrder(inputParcels, ItemType.SPEEDY_DELIVERY);

        OrderManager orderManager = new OrderManager();
        String actualResult = orderManager.placeOrder(inputOrder);

        // Creating expected output
        String expectedOutput = "{\"items\":[{\"cost\":25.0,\"type\":\"XL_PARCEL\"},{\"cost\":15.0,\"type\":\"LARGE_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":3.0,\"type\":\"SMALL_PARCEL\"},{\"type\":\"SPEEDY_DELIVERY\",\"cost\":51.0}],\"totalCost\":102.0}";

        // Comparing input vs output
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderWithRegularShippingDiscount3x8MediumsAnd3x10MediumsComputesTotalCost36() {
        ArrayList<InputParcel> inputParcels = new ArrayList<>();
        InputParcel m1 = new InputParcel(49.0, 3);
        InputParcel m2 = new InputParcel(49.0, 3);
        InputParcel m3 = new InputParcel(49.0, 3);
        InputParcel m4 = new InputParcel(49.0, 4);
        InputParcel m5 = new InputParcel(49.0, 4);
        InputParcel m6 = new InputParcel(49.0, 4);

        inputParcels.add(m1);
        inputParcels.add(m2);
        inputParcels.add(m3);
        inputParcels.add(m4);
        inputParcels.add(m5);
        inputParcels.add(m6);

        OrderManager orderManager = new OrderManager();
        InputOrder inputOrder = new InputOrder(inputParcels, ItemType.REGULAR_DELIVERY);
        String actualResult = orderManager.placeOrder(inputOrder);

        String expectedOutput = "{\"items\":[{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"type\":\"DISCOUNT\",\"cost\":-18.0}],\"totalCost\":36.0}";

        // Comparing input vs output
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderWithSpeedyShippingDiscount3x8MediumsAnd3x10MediumsComputesTotalCost90() {
        ArrayList<InputParcel> inputParcels = new ArrayList<>();
        InputParcel m1 = new InputParcel(49.0, 3);
        InputParcel m2 = new InputParcel(49.0, 3);
        InputParcel m3 = new InputParcel(49.0, 3);
        InputParcel m4 = new InputParcel(49.0, 4);
        InputParcel m5 = new InputParcel(49.0, 4);
        InputParcel m6 = new InputParcel(49.0, 4);

        inputParcels.add(m1);
        inputParcels.add(m2);
        inputParcels.add(m3);
        inputParcels.add(m4);
        inputParcels.add(m5);
        inputParcels.add(m6);

        OrderManager orderManager = new OrderManager();
        InputOrder inputOrder = new InputOrder(inputParcels, ItemType.SPEEDY_DELIVERY);
        String actualResult = orderManager.placeOrder(inputOrder);

        String expectedOutput = "{\"items\":[{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":10.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"cost\":8.0,\"type\":\"MEDIUM_PARCEL\"},{\"type\":\"DISCOUNT\",\"cost\":-18.0},{\"type\":\"SPEEDY_DELIVERY\",\"cost\":54.0}],\"totalCost\":90.0}";

        // Comparing input vs output
        assertEquals(expectedOutput, actualResult);
    }
}
