
public class QuickSort {

    public static void main(String [] args) {
        if (args != null) {
            int [] array = new int[args.length];
            
            for (int i = 0; i < args.length; ++i) {
                array[i] = Integer.parseInt(args[i]);
            }
            
            quickSort(array, 0, array.length - 1);

            //this better be sorted!!!
            for (int i = 0; i < array.length; ++i) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }
    }
    
    private static void quickSort(int [] array, int left, int right) {
        if (left >= right) return;
        
        int pivotIndex = choosePivotIndex(left, right);

        int newPivotIndex = arrange(array, pivotIndex, left, right);

        quickSort(array, left, newPivotIndex);
        quickSort(array, newPivotIndex + 1, right);
    }

    private static int choosePivotIndex(int left, int right) {
        return (left + right)/2;
    }

    private static int arrange(int [] array, int pivotIndex, int left, int right) {
        
        int pivotValue = array[pivotIndex];
        
        swap(array, pivotIndex, right);

        int indexSwapTo = left;
        
        for (int i = left; i < right; ++i) {
            if (array[i] < pivotValue) {
                swap(array, indexSwapTo, i);
                ++indexSwapTo;
            }            
        }
        
        swap(array, indexSwapTo, right);
        
        return indexSwapTo;
    }

    private static void swap(int [] array, int toIndex, int fromIndex) {
        int tmp = array[toIndex];
        array[toIndex] = array[fromIndex];
        array[fromIndex] = tmp;
    }
}
