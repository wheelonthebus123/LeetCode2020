import java.util.ArrayList;
import java.util.List;

public class IntersectionofThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ret = new ArrayList<Integer>();
        int i1 = 0, i2 = 0, i3 = 0;

        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {
            int v1 = arr1[i1], v2 = arr2[i2], v3 = arr3[i3];
            if (v1 == v2 && v2 == v3) {
                ret.add(v1);
                i1++;
                i2++;
                i3++;
            } else if (v1 <= v2 && v1 <= v3) {
                i1++;
            } else if (v2 <= v1 && v2 <= v3) {
                i2++;
            } else {
                i3++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}