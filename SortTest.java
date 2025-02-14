import org.junit.jupiter.api.*;
public class SortTest {
    @Test
    void testInsertionSortHappyPath(){
        Integer[] arr = {3, 2, 1};
        Sort<Integer> sort = new Sort<>();
        Integer[] sortedArr = sort.insertionSort(arr);
        Assertions.assertEquals(1, sortedArr[0]);
        Assertions.assertEquals(2, sortedArr[1]);
        Assertions.assertEquals(3, sortedArr[2]);
    }

    @Test
    void testMergeSortHappyPath(){
        Integer[] arr = {3, 2, 1};
        Sort<Integer> sort = new Sort<>();
        Integer[] sortedArr = sort.mergeSort(arr);
        Assertions.assertEquals(1, sortedArr[0]);
        Assertions.assertEquals(2, sortedArr[1]);
        Assertions.assertEquals(3, sortedArr[2]);
    }

    @Test
    void testCountingSortHappyPath() {
        Integer[] arr = {3, 2, 1};
        Sort<Integer> sort = new Sort<>();
        Integer[] sortedArr = sort.countingSort(arr);
        Assertions.assertEquals(1, sortedArr[0]);
        Assertions.assertEquals(2, sortedArr[1]);
        Assertions.assertEquals(3, sortedArr[2]);
    }

}
