import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] a = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }


    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                }
            }
        }
    }

    static void swap(int a, int b, int[] c) {
        int temp = 0;
        temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}