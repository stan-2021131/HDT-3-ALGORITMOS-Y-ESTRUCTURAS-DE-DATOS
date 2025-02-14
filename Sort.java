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
    public T[] quickSort(T[] arr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quickSort'");
    }

    @Override
    public T[] radixSort(T[] arr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'radixSort'");
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
