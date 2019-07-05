class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> unique_code = new HashSet <>();
        
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String word : words){
            StringBuilder transformation = new StringBuilder();
                for(char c : word.toCharArray()){
                    transformation.append(MORSE[c - 'a']);
            }
        unique_code.add(transformation.toString());
    }
                
       return unique_code.size();
}
}