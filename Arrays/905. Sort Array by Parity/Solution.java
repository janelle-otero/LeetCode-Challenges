class Solution {
    public int[] sortArrayByParity(int[] A) {
        for(int j=0, i=0; j < A.length; j++){
            if(A[j] % 2 == 0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        return A;  
    }
}