
public class Main {
    public static void main(String[] args) {
        String file = "List.txt";
        FileControl fc = new FileControl();

        // Generar números y escribir en archivo
        String result = fc.writeList(file, fc.generateNumbers(3000, 0, 100000)); // Cambia el tamaño la cantidad y rango
        System.out.println(result);
        Integer[] originalList = fc.loadList(file);
        Sort mySort = new Sort();

        // Medir tiempos de cada sort
        measureSortTime(mySort, originalList, "Insertion Sort", "insertionSort");
        measureSortTime(mySort, originalList, "Merge Sort", "mergeSort");
        measureSortTime(mySort, originalList, "Quick Sort", "quickSort");
        measureSortTime(mySort, originalList, "Radix Sort", "radixSort");
        measureSortTime(mySort, originalList, "Counting Sort", "countingSort");
    }

    private static void measureSortTime(Sort sorter, Integer[] originalList, String sortName, String methodName) {
        // Clonar la lista original para evitar que un sort afecte al siguiente
        Integer[] list = originalList.clone();

        // Tomar el tiempo de inicio
        long startTime = System.nanoTime();

        // Llamar al método correspondiente según su nombre
        switch (methodName) {
            case "insertionSort" -> sorter.insertionSort(list);
            case "mergeSort" -> sorter.mergeSort(list);
            case "quickSort" -> sorter.quickSort(list, 0, list.length - 1);
            case "radixSort" -> sorter.radixSort(list);
            case "countingSort" -> sorter.countingSort(list);
        }

        // Tomar el tiempo de finalización
        long endTime = System.nanoTime();

        // Calcular tiempo total en milisegundos
        double duration = (endTime - startTime) / 1e6;
        System.out.printf("%s completed in %.3f ms%n", sortName, duration);
    }
}
