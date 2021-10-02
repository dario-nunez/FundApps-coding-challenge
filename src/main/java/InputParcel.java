/**
 * Temporary input class to facilitate testing.
 */
public class InputParcel {
    private double dimensions;
    private double weight;

    public InputParcel(double dimensions, double weight) {
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public double getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }
}
