import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[20_000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) Math.round((Math.random() * 200) - 100);
        }
        int[] array2 = new int[2_000];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) Math.round((Math.random() * 200) - 100);
        }

        System.out.println("Было array1:" + "\n" + Arrays.toString(array1));
        long startTime = System.currentTimeMillis();
        quickSort(array1);
        long finishTime = System.currentTimeMillis();
        System.out.println("Сортировка quickSort(array1): " + "\n" + Arrays.toString(array1));


        System.out.println("Было array2:" + "\n" + Arrays.toString(array2));
        long startTime2 = System.currentTimeMillis();
        shakerSort(array2);
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Сортировка shakerSort(array2): " + "\n" + Arrays.toString(array2));


        System.out.println("Сортировка quickSort: " + (finishTime - startTime) + "ms");
        System.out.println("Сортировка shakerSort: " + (finishTime2 - startTime2) + "ms");

    }

    public static void shakerSort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int high) {

        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            sort(array, low, j);

        if (high > i)
            sort(array, i, high);
    }
}