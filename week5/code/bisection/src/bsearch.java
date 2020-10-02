public class bsearch {
    public static int binarySearch(int[] values, int searchValue) {
        int i0 = 0, i1 = values.length - 1;
        while (i0 < i1) {
            int iMid = (i0 + i1) / 2, v = values[iMid];
            if (v == searchValue) return iMid;
            if (v > searchValue) i1 = iMid - 1;
            else i0 = iMid + 1;
        }
        return i0;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,6,7,10,18};
        int res = binarySearch(arr,4);
        System.out.println(res);
    }


}

