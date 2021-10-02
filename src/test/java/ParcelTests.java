import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ParcelTests {
    @Test
    public void smallParcelGetsAssignedACostOf3(){
        Parcel p1 = new Parcel(9.0,1);
        Parcel p2 = new Parcel(10.0,1);

        assertEquals(p1.getCost(), 3.0, 0.001);
        assertEquals(p1.getType(), ItemType.SMALL_PARCEL);

        assertNotEquals(p2.getCost(), 3.0, 0.001);
        assertNotEquals(p2.getType(), ItemType.SMALL_PARCEL);
    }

    @Test
    public void mediumParcelGetsAssignedACostOf8(){
        Parcel p1 = new Parcel(48.0,3);
        Parcel p2 = new Parcel(50.0,3);

        assertEquals(p1.getCost(), 8.0, 0.001);
        assertEquals(p1.getType(), ItemType.MEDIUM_PARCEL);

        assertNotEquals(p2.getCost(), 8.0, 0.001);
        assertNotEquals(p2.getType(), ItemType.MEDIUM_PARCEL);
    }

    @Test
    public void largeParcelGetsAssignedACostOf15(){
        Parcel p1 = new Parcel(99.0,6);
        Parcel p2 = new Parcel(100.0,6);

        assertEquals(p1.getCost(), 15.0, 0.001);
        assertEquals(p1.getType(), ItemType.LARGE_PARCEL);

        assertNotEquals(p2.getCost(), 15.0, 0.001);
        assertNotEquals(p2.getType(), ItemType.LARGE_PARCEL);
    }

    @Test
    public void xlParcelGetsAssignedACostOf25(){
        Parcel p1 = new Parcel(100.0,10);
        Parcel p2 = new Parcel(99.0,10);
        Parcel p3 = new Parcel(101,10);

        assertEquals(p1.getCost(), 25.0, 0.001);
        assertEquals(p1.getType(), ItemType.XL_PARCEL);

        assertNotEquals(p2.getCost(), 25.0, 0.001);
        assertNotEquals(p2.getType(), ItemType.XL_PARCEL);

        assertEquals(p3.getCost(), 25.0, 0.001);
        assertEquals(p3.getType(), ItemType.XL_PARCEL);
    }

    @Test
    public void small1kgPackageCosts3(){
        Parcel p1 = new Parcel(9.0, 1);

        assertEquals(p1.getCost(), 3.0, 0.001);
        assertEquals(p1.getType(), ItemType.SMALL_PARCEL);
    }

    @Test
    public void small2kgPackageCosts5(){
        Parcel p1 = new Parcel(9.0, 2);

        assertEquals(p1.getCost(), 5.0, 0.001);
        assertEquals(p1.getType(), ItemType.SMALL_PARCEL);
    }

    @Test
    public void medium3kgPackageCosts8(){
        Parcel p1 = new Parcel(49.0, 3);

        assertEquals(p1.getCost(), 8.0, 0.001);
        assertEquals(p1.getType(), ItemType.MEDIUM_PARCEL);
    }

    @Test
    public void medium4kgPackageCosts10(){
        Parcel p1 = new Parcel(49.0, 4);

        assertEquals(p1.getCost(), 10.0, 0.001);
        assertEquals(p1.getType(), ItemType.MEDIUM_PARCEL);
    }

    @Test
    public void large6gPackageCosts15(){
        Parcel p1 = new Parcel(99.0, 6);

        assertEquals(p1.getCost(), 15.0, 0.001);
        assertEquals(p1.getType(), ItemType.LARGE_PARCEL);
    }

    @Test
    public void large7kgPackageCosts17(){
        Parcel p1 = new Parcel(99.0, 7);

        assertEquals(p1.getCost(), 17.0, 0.001);
        assertEquals(p1.getType(), ItemType.LARGE_PARCEL);
    }

    @Test
    public void xl10gPackageCosts25(){
        Parcel p1 = new Parcel(101.0, 10);

        assertEquals(p1.getCost(), 25.0, 0.001);
        assertEquals(p1.getType(), ItemType.XL_PARCEL);
    }

    @Test
    public void heavy50kgPackageCosts50(){
        Parcel p1 = new Parcel(1.0, 11);

        assertEquals(p1.getCost(), 50.0, 0.001);
        assertEquals(p1.getType(), ItemType.HEAVY_PARCEL);
    }

    @Test
    public void heavy60kgPackageCosts(){
        Parcel p1 = new Parcel(1.0, 60);

        assertEquals(p1.getCost(), 60, 0.001);
        assertEquals(p1.getType(), ItemType.HEAVY_PARCEL);
    }
}
