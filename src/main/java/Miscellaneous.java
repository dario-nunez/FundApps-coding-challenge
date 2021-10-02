/**
 * Anything that can be added to an order that is not a Parcel.
 */
public class Miscellaneous extends Item{
    private ItemType type;
    private double cost;

    public Miscellaneous(ItemType type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public double getCost() {
        return cost;
    }
}