/**
 * Represents anything that can be added to an order.
 */
public abstract class Item implements Comparable<Item> {
    public abstract ItemType getType();
    public abstract double getCost();

    @Override
    public String toString() {
        return "Item{" +
                "type=" + getType() +
                ", cost=" + getCost() +
                '}';
    }

    @Override
    public int compareTo(Item i) {
        return Double.compare(i.getCost(), getCost());
    }
}