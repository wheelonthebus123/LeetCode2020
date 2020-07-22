public class MaxChunksToMakeSorted_769 {
    public int maxChunksToSorted(int[] arr) {
        int count = 0, max = 0;
        for(int i=0; i<arr.length; ++i){
            max = Math.max(max, arr[i]);
            if(max == i) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}