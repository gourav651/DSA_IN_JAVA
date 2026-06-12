class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char c : (path + '/').toCharArray()){
            if(c == '/'){
                String part = cur.toString();

                if(part.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else if(!part.equals("") && !part.equals(".")){
                    stack.push(part);
                }
                cur.setLength(0);
            }else{
                cur.append(c);
            }
        }
        return "/" + String.join("/",stack);
    }
}