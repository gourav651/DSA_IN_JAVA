class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0;
        int r=0;
        int maxLength=0;
        int[] hash = new int[256];

        Arrays.fill(hash,-1);

        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)]+1;
                }
            }
            int length = r-l+1;
            maxLength = Math.max(length,maxLength);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLength;
    }
}