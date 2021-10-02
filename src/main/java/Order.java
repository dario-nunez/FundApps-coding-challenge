import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Represents an Order object.
 */
@JsonIgnoreProperties(value = { "discount"})
public class Order {
    private ArrayList<Item> items;
    private double cost = 0.0;
    private double discount = 0.0;
    private double totalCost = 0.0;

    public Order(ArrayList<Parcel> parcels, ItemType deliveryType) {
        this.items = new ArrayList<>();

        // 1. Add items and their costs
        for (Parcel parcel : parcels) {
            addItem(parcel);
        }

        // 2. Add discounts
        applyDiscounts();

        // 3. Add shipping costs
        applyShippingCost(deliveryType);

        totalCost = cost - discount;
    }

    private void applyDiscounts() {
        Collections.sort(items);

        double discountedPrice = 0;

        int smallThreshold = 4;
        int mediumThreshold = 3;
        int mixedThreshold = 5;

        int seenSmalls = 0;
        int seenMediums = 0;
        int seenMixed = 0;

        for (Item item : items) {
            if (item.getType().equals(ItemType.SMALL_PARCEL)) {
                seenSmalls++;
                seenMixed++;
            } else if (item.getType().equals(ItemType.MEDIUM_PARCEL)) {
                seenMediums++;
                seenMixed++;
            } else {
                seenMixed++;
            }

            if (seenSmalls == smallThreshold || seenMediums == mediumThreshold || seenMixed == mixedThreshold) {
                discountedPrice = discountedPrice + item.getCost();
                seenSmalls = 0;
                seenMediums = 0;
                seenMixed = 0;
            }
        }

        if (discountedPrice!= 0) {
            items.add(new Miscellaneous(ItemType.DISCOUNT, -discountedPrice));
            setDiscount(discountedPrice);
        }
    }

    private void applyShippingCost(ItemType deliveryType) {
        if (deliveryType.equals(ItemType.SPEEDY_DELIVERY)) {
            Item delivery = new Miscellaneous(ItemType.SPEEDY_DELIVERY, cost);
            addItem(delivery);
        }
    }

    private void addItem(Item item) {
        items.add(item);
        cost = cost + item.getCost();
    }

    public ArrayList<Item> getParcels() {
        return items;
    }

    public double getTotalCost() {
        return cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> receipt = new HashMap<>();

        receipt.put("items", items);
        receipt.put("totalCost", totalCost);

        try {
            return objectMapper.writeValueAsString(receipt);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
