class Solution {
    public List<String> findWords(char[][] board, String[] words) {
         if(board == null || board.length == 0 || board[0].length == 0)
            return null;
        
        //*** Create tree by 'words'
        Node root = new Node((char)0);
        for(String w : words){
            insert(root, w);
        }
        
        //*** Search words in 'board'
        Set<String> hsRes = new HashSet<>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                Set<String> hs = search(board, root, new Point(row, col));
                if(hs!=null)
                    hsRes.addAll(hs);
            }
        }
        return new ArrayList<String>(hsRes);
    }
    
    //*** For move to left, top, right, bottom
    private final int[][] sides = {{0,-1},{-1,0},{0,1},{1,0}};
    
    private Set<String> search(char[][] board, Node node, Point p){
        if(p.row < 0 || p.row >= board.length || p.col < 0 || p.col >= board[0].length)
            return null;
        char ch = board[p.row][p.col];
        
        //*** If we already have been here, in the current track
        if(ch == '#')
            return null;
        Node child = node.children.get(ch);
        if(child == null || child.count < 1)
            return null;
        Set<String> hsRes = new HashSet<>();
        
         //*** If we find the word -> add it to the list of results and remove the 'val'
        if(child.val != null) {
            hsRes.add(child.val);
            child.val = null;
        }
        
        //*** Mark that we have been here, for the next steps
        board[p.row][p.col] = '#';
        for(int[] side : sides){
            Set<String> hs = search(board, child, new Point(p.row+side[0], p.col+side[1]));
            if(hs != null)
                hsRes.addAll(hs);
        }
        
        //*** Remove the mark that we have been here
        board[p.row][p.col] = ch;
        
        //*** Reduce the number of words contained in this node and in the lower levels
        child.count -= hsRes.size();
        return hsRes.size() > 0 ? hsRes : null;
    }
    
    //*** Create the tree
    private void insert(Node root, String w){
        char[] arr = w.toCharArray();
        Node node = root;
        node.count++;
        for(char ch : arr){
            Node child = node.children.get(ch);
            if(child == null){
                child = new Node(ch);
                node.children.put(ch, child);
            }
            
            //*** Mark the number of words contained in this node and in the lower levels
            child.count++;
            node = child;
        }
        node.val = w;
    }
    
    private class Node {
        char ch;
        Map<Character, Node> children;
        String val;
        
        //*** The number of words contained in this node and in the lower levels
        int count;
        
        public Node(char ch){
            this.ch = ch;
            children = new HashMap<>();
        }
    }
    
    private class Point {
        int col;
        int row;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    }