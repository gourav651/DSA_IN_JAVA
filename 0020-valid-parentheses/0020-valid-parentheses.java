class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();  //to store the char values

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                st.push(curr);
            }else{
                if(st.empty()) return false;

                char ch = st.peek();
                st.pop();
                if((curr == ')' && ch == '(') ||
                (curr == '}' && ch == '{') || 
                (curr == ']' && ch == '[')){

                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}