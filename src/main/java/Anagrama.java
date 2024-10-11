public class Anagrama {
    public static void main(String[] args) throws Exception {
        Solution_A sol = new Solution_A();
        System.out.println(sol.isAnagram("bbbbbacc", "ccbbbbaa"));
    }
}
class Solution_A {
    public boolean isAnagram(String s, String t) throws Exception {
        if(s.length()!= t.length()) return false;

        int n = s.length();
        int counter = 0;
        boolean var;

        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s_char[i] == t_char[j]) {
                    t_char[j] = '\uFFFF';
                    counter++;
                    break;
                }
            }
        }
        return n == counter;

    }
}
