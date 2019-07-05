class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet <Character> jewels = new HashSet <>();
        for(char c: J.toCharArray()){
            jewels.add(c);
        }
        int numJewels = 0;
            for(char c: S.toCharArray()){
                if(jewels.contains(c)){
                numJewels++;
                    }
            }
        return numJewels;
    }
}