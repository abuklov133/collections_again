package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void when100ElementsThenSizeMustBe100() {
        assertSame(100, carList.size());
    }

    @Test
    void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertSame(99, carList.size());
    }

    @Test
    void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("BMW", 10);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    void whenRemovedNonExistentElementThenSizeDoesNotChangeReturnFalce() {
        Car car = new Car("BMW", 10);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    void whenIndexOutOfBoundThenThrownException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.get(100);
        });
    }

    @Test
    void methodGetReturnedRightValue() {
        Car car = carList.get(50);
        assertEquals("Brand50", car.getBrand());
    }
}

