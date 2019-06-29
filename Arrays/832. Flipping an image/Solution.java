class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i<A.length; i++){
            int j = 0, r=A[i].length-1;
                while(j<=r){
                int tmp = A[i][j];
                A[i][j] = A[i][r]^1;
                A[i][r] =tmp^1;
                j++; r--;
                }
                
            }
        return A;
        }
    }
