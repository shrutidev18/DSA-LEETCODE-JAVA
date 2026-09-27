class Solution {
    public String reverseParentheses(String s) {
        int l=s.length();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(c != ')'){
                stk.push(c);
            }
            else{
                String t ="";
                while(stk.peek() != '('){
                    t=t+stk.pop();
                }
                stk.pop();
                for(int j=0;j<t.length();j++){
                    stk.push(t.charAt(j));
                }
            }
        }
        StringBuilder res = new StringBuilder();

        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        return res.reverse().toString();
    }
}