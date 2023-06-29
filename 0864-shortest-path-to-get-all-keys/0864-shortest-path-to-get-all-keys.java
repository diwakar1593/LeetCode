class Solution {
    public int shortestPathAllKeys(String[] grid) {
            int y = grid.length, x = grid[0].length(), maskKeys = 0;
    int vis[][][] = new int[y][x][64];             //for all variants of sets of keys

    LinkedList<int[]> q = new LinkedList<>();      //key, y, x
    for(int i = 0; i != y; ++i)                            
      for(int j = 0; j != x; ++j){
        char ch = grid[i].charAt(j); 
        if(ch == '@') q.add(new int[]{0, i, j});               //find out start position
        else if(ch > 'Z') maskKeys |= 1<< (ch - 'a');          //and constract mask for all presented keys
      }
    
    for(int lev = 0; !q.isEmpty(); ++lev)          //BFS
      for(int n = q.size(); n != 0; --n){
        int t[] = q.pollFirst();                   //fetch current position
        int key = t[0], r = t[1], c = t[2];
        
        if(r == -1 || r == y || c == -1 || c == x || vis[r][c][key] == 1) continue;

        char ch = grid[r].charAt(c);
        if(ch == '#') continue;

        if(ch > '@' && ch < 'a')                   //if we in lock position
          if( (key & ( 1<< (ch - 'A'))) == 0) continue;   // and we dont have right key
        
        if(ch > 'Z') {                             //if we in key position
          key |= 1<< (ch - 'a');         
          if(key == maskKeys) return lev;          //check ? have we all keys   
        }

        vis[r][c][key] = 1;

        q.addLast(new int[]{key, r-1, c});
        q.addLast(new int[]{key, r+1, c});
        q.addLast(new int[]{key, r, c-1});
        q.addLast(new int[]{key, r, c+1});                
      }
    
    return -1; 
    }
}