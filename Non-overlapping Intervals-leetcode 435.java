class Solution {
  class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
  }
    
    public boolean overlap(int[] p,int[] c){
        if(c[0]<p[1])
            return true;
        
        return false;
    }
    
  public int minInt(int prev,int cur,int[][] intervals,int len,int[][] cache){
      if(cur==len)
          return 0;
      if(cache[prev+1][cur]>-1)
          return cache[prev+1][cur];
      if(prev!=-1 && overlap(intervals[prev],intervals[cur])){
          int c1=minInt(prev,cur+1,intervals,len,cache);
          int c2=minInt(cur,cur+1,intervals,len,cache);
          cache[prev+1][cur]=Math.min(c1+1,c2+1);
          return cache[prev+1][cur];
      }
      
      cache[prev+1][cur]=minInt(cur,cur+1,intervals,len,cache);
      return cache[prev+1][cur];
  }  

  public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new myComparator());
        /*int[][] cache=new int[intervals.length+1][intervals.length];
        for(int i=0;i<cache.length;i++){
            for(int j=0;j<cache[0].length;j++){
                cache[i][j]=-1;
            }
        }
        return minInt(-1,0,intervals,intervals.length,cache);*/
        int[][] cache=new int[intervals.length][intervals.length+1];
        /*for(int i=0;i<cache[0].length;i++){
            cache[cache.length-1][i]=0;
        }
        for(int i=0;i<cache.length;i++){
            cache[i][cache.length-1]=0;
        }
        cache[cache.length-2][cache.length-2]=0;*/
        int row=cache.length-2;
        while(row>=0){
            int col=intervals.length-1;
            while(col>row){
                //System.out.println(row+" "+col);
                if(overlap(intervals[row],intervals[col])){
                    cache[row][col]=Math.min(cache[row][col+1]+1,cache[col][col+1]+1);
                }else{
                    cache[row][col]=cache[col][col+1];
                }
                col--;
            }
            row--;
        }
        
        return cache[0][1];
  }
}