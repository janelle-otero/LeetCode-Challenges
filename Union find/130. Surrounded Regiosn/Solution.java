class Solution {
    static class Pair {
    public int first;
    public int second;
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public void solve(char[][] board) {
    if(board == null || board.length == 0) {
        return ;
    }
    for(int i = 0; i < board[0].length; ++i) {
        if(board[0][i] == 'O') {
            markUnflippable(board,0,i);
        }
    }
    for(int i = 0; i < board[board.length-1].length; ++i) {
        if(board[board.length-1][i] == 'O') {
            markUnflippable(board,board.length-1,i);
        }
    }
    for(int i = 0 ; i < board.length; ++i) {
        if(board[i][0] == 'O') {
            markUnflippable(board,i,0);
        }
    }
    for(int i =0; i < board.length; ++i) {

