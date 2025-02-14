public class Sort<T extends Comparable<T>> implements IGenericSort<T>{

    @Override
    public T[] insertionSort(T[] arr) {
        for(int i = 1; i < arr.length; i++){
            T currentValue = arr[i];
            int j = i-1;
            while(j>=0 && arr[j].compareTo(currentValue)>0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = currentValue;
        }return arr;
    }

    @Override
    public T[] mergeSort(T[] arr) {
        int n = arr.length;
        if (n<2){
            return arr;  
        }
        int mid = n/2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[n-mid];
        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        for(int i = mid; i < n; i++){
            right[i-mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
        return arr;
    }
    
    private void merge(T[] arr, T[] left, T[] right){
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize){
            if(left[i].compareTo(right[j]) <= 0){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    @Override
    public T[] quickSort(T[] arr, int left, int right) {
        T pivot = arr[left];
        int l = left;
        int r = right;
        T aux;
        while (l<r) { 
            while(arr[l].compareTo(pivot) <= 0 && l<r) l++;
            while(arr[r].compareTo(pivot) > 0) r--;
            if(l<r){
                aux = arr[l];
                arr[l] = arr[r];
                arr[r] = aux;
            }
        }
        arr[left] = arr[r];
        arr[r] = pivot;
        if(left < r-1) quickSort(arr, left, r-1);
        if(r+1 < right) quickSort(arr, r+1, right);
        return arr;
    }

    @Override
    public T[] radixSort(T[] arr) {
        int size = arr.length;
        Integer[] tempArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            tempArr[i] = ((Integer) arr[i]).intValue();
        }
        int maxElement = ((Integer) getMax(arr)).intValue();
        for (int place = 1; maxElement / place > 0; place *= 10) {
            tempArr = countingSortV2(tempArr, place);
        }
        for (int i = 0; i < size; i++) {
            arr[i] = (T) Integer.valueOf(tempArr[i]);
        }
        return arr;
    }

    //Segunda versión del counting sort, usado para el funcionamiento del radix sort, ordena los elementos basado en lugares significativos
    private Integer[] countingSortV2(Integer[] arr, int place) {
        int size = arr.length;
        Integer[] output = new Integer[size];
        int[] count = new int[10];
        for (int i = 0; i < size; i++) {
            int index = (arr[i] / place) % 10;
            count[index]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            int index = (arr[i] / place) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
        return output;
    }

    //Obtiene el valor máximo del arr - para radixsort
    private T getMax(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    /*Sort a eleccion */
    @Override
    public T[] countingSort(T[] arr) {
        if (arr == null || arr.length == 0){
            return arr;   
        }
        T min = arr[0];
        T max = arr[0];
        for(T element : arr){
            if(element.compareTo(min) < 0){
                min = element;
            }else if(element.compareTo(max) > 0){
                max = element;
            }
        }
        int range = getRange(max, min);
        int[] count = new int[range+1];
        for(T element : arr){
            count[getIndex(element, min)]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        T[] output = (T[]) new Comparable[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            output[count[getIndex(arr[i], min)]-1] = arr[i];
            count[getIndex(arr[i], min)]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
        return arr;
    }

    private int getRange(T max, T min){
        if (max instanceof Integer) {
            return ((Integer) max - (Integer) min);
        }
        throw new UnsupportedOperationException("Only integers are supported");
    }

    private int getIndex(T element, T min) {
        if (element instanceof Integer) {
            return ((Integer)element) - ((Integer)min);
        }
        throw new UnsupportedOperationException("Tipo no soportado para Counting Sort");
    }
    
}
