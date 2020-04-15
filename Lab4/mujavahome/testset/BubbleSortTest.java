import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void bubbleSort() {
        int a[] = new int[]{1, 6, 2, 2, 5};
        int b[] = new int[]{2, 2, 2, 1, 2, 13};
        int c[] = new int[]{1, 2, 2, 5, 6};
        int d[] = new int[]{1, 2, 2, 2, 2, 13};

        assertEquals(Arrays.toString(c), Arrays.toString(bubbleSort.BubbleSort(a)));
        assertEquals(Arrays.toString(d), Arrays.toString(bubbleSort.BubbleSort(b)));
    }
}