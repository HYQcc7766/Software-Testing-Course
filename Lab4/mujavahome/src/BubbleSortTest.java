/**
 * 
 */

/**
 * @author m^_^m
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class BubbleSortTest {
		
	@Test
	public void test() {
		int[] expected = new int[]{0,1,3,4,7};
		int[] origin = new int[]{1,0,3,7,4};
		assertArrayEquals(expected, BubbleSort.BubbleSort(origin));
	}
}