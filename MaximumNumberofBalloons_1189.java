public class MaximumNumberofBalloons_1189 {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for(char c: text.toCharArray())
        {
            chars[c-'a']++;
        }

        int r = chars[1];//b
        r = Math.min(r, chars[0]);//a
        r = Math.min(r, chars[11]/2);//l/2
        r = Math.min(r, chars[14]/2);//o/2
        r = Math.min(r, chars[13]);//n

        return r;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}