public class FindWordsThatCanBeFormedbyCharacters_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for(char c : chars.toCharArray())
        {
            counts[c-'a']++;
        }

        int ret = 0;
        for(String w : words)
        {
            int[] counts1  = counts.clone();
            boolean match = true;
            for(char c:w.toCharArray())
            {
                if(--counts1[c-'a'] < 0)
                {
                    match = false;
                    break;
                }
            }
            if(match)
            {
                ret += w.length();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}