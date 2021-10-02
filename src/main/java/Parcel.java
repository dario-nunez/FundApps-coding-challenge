import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a Parcel.
 */
@JsonIgnoreProperties(value = { "dimensions", "weight" })
public class Parcel extends Item {
    private double dimensions;
    private double cost;
    private ItemType type;
    private double weight;

    public Parcel(double dimensions, double weight) {
        this.dimensions = dimensions;
        this.weight = weight;

        assignType();
        assignCost();
    }

    private void assignType() {
        if (weight > 10) {
            type = ItemType.HEAVY_PARCEL;
        } else {
            if (getDimensions() < 10.0) {
                setType(ItemType.SMALL_PARCEL);
            } else if (getDimensions() < 50) {
                setType(ItemType.MEDIUM_PARCEL);
            } else if (getDimensions() < 100) {
                setType(ItemType.LARGE_PARCEL);
            } else {
                setType(ItemType.XL_PARCEL);
            }
        }
    }

    private void assignCost() {
        double weightLimit;
        double rate = 2.0;

        switch (getType()){
            case SMALL_PARCEL:
                weightLimit = 1.0;
                cost = 3;
                break;
            case MEDIUM_PARCEL:
                weightLimit = 3.0;
                cost = 8.0;
                break;
            case LARGE_PARCEL:
                weightLimit = 6.0;
                cost = 15.0;
                break;
            case XL_PARCEL:
                weightLimit = 10.0;
                cost = 25.0;
                break;
            default:
                weightLimit = 50;
                cost = 50;
                rate = 1;
                break;
        }

        if (weight > weightLimit) {
            cost = cost + (weight - weightLimit) * rate;
        }
    }

    public double getDimensions() {
        return dimensions;
    }

    public double getCost() {
        return cost;
    }

    public ItemType getType() {
        return type;
    }

    public void setDimensions(double dimensions) {
        this.dimensions = dimensions;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
