class Solution {
    public String reverseWords(String s) {
        s = s.trim();
      
        String[] words = s.split("\\s+");
      
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));      
        System.out.println(sol.reverseWords("  hello world  "));     
        System.out.println(sol.reverseWords("a good   example"));   
        System.out.println(sol.reverseWords("    "));                
        System.out.println(sol.reverseWords("word"));                 
    }
}
