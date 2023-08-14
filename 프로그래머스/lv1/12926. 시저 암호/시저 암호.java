class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for ( char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            
            
            if ((Character.isLowerCase(c) && c+n > 'z') ||(Character.isUpperCase(c) && c+n > 'Z')) {
             c-=26;  
            }
         
            c += n;
            
            sb.append(c);
        }
        return sb.toString();
    }
}