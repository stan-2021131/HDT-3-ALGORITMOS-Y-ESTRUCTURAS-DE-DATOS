//Interfaz en donde se encuentran los distintos algoritmos
public interface IGenericSort<T extends Comparable<T>>{
    public T[] insertionSort(T[] arr);
    public T[] mergeSort(T[] arr);
    public T[] quickSort(T[] arr, int left, int right);
    public T[] radixSort(T[] arr);
    public T[] countingSort(T[] arr);
}