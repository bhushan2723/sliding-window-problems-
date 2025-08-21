class Solution {
    public int compress(char[] chars) {
        int index = 0;  
        int i = 0;  

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

           
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            
            chars[index++] = currentChar;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int j = 0; j < countStr.length(); j++) {
                    chars[index++] = countStr.charAt(j);
                }
            }
        }
        
        return index; 
    }
}
