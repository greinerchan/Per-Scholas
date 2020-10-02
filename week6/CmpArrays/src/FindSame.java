import java.util.*;

public class FindSame {
    public static List<Integer> findSame(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0, j = 0;
        while ( i < arr1.size() && j < arr2.size() ) {
            if (arr1.get(i) == arr2.get(j)) {
                ans.add(arr1.get(i));
                i++; j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        List<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(50,20,3,4,6,7,9,12,15,17,23));
        List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(3,5,7,9,10,13,15,18,23));
        IntCompr comparator = new IntCompr();
        Collections.sort(arr1,comparator);
        //List<Integer> ans = findSame(arr1, arr2);

        System.out.println(arr1);
    }
}
