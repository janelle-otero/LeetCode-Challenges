class Solution {
    public boolean isHappy(int n) {
 HashSet<Integer> happy = new HashSet<>();
        while (n != 1){
            int sum = 0;
            while(n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(happy.contains(sum)){
                return false;
            }
            happy.add(sum);
            n = sum;
        }
        return true;
    }
}