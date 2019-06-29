class Solution {
    public boolean isSelfDividing(int num){
        
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = left: i < right; i++){
            if(isSelfDividing(i)){
                list.add(i);
            }
}
        return list;
    }
}
