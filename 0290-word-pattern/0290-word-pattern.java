class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words =s.split(" ");

        // Step 1: Length check
        if(pattern.length() != words.length) return false;

        // Step 2: Create two maps for bijection
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

         // Step 3: Traverse pattern and words
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = words[i];

        // Check pattern -> word mapping
        if(map1.containsKey(ch)){
            if(!map1.get(ch).equals(word)) return false;
        }else{
            map1.put(ch, word);
        }

         // Check word -> pattern mapping
         if(map2.containsKey(word)){
            if(map2.get(word) != ch) return false;
         }else{
            map2.put(word, ch);
         }
        }
        return true;
    }
}