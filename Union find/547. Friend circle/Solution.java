class Solution {
 public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for(int row=0;row<M.length;++row){
            if(!visited[row]){
                dfs(M,row,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M,int row,boolean[] visited){
        visited[row]=true;
        for(int i=0;i<M[row].length;++i){
            if(!visited[i]&&M[row][i]==1){
                dfs(M,i,visited);
            }
        }
    }
}
