public class Stock {
    
    private int[] stock(int[] P,int[] b,int[] s){

        /* This function takes stock prices in P, buy patterns in b, sell patterns in s and returns
            a list of positions based on buy and sell patterns. Running time O(n3) where n is length of Price array P*/

        int[] res=new int[P.length];
        for(int i=0;i<res.length;i++)
            res[i]=0;
        
        for(int p=1;p<res.length;p++){ //for every index in P find whether that index results in a buy position or sell position


            for(int k=1;k<=p;k++){    //This logic checks for buy position
                int i=k,m=0;
                while(i<=p){
                    if(P[i-1]<P[i]){
                        if(m==b.length || b[m]==-1)
                            break;
                         m++;
                    }else if(P[i-1]>P[i]){
                        if(m==b.length || b[m]==1)
                            break;
                        m++;
                    }
                    i++;
                }
                
                if(i>p && m==b.length){
                    res[p]=res[p-1]+1;    //since it is a buy position, increment the result for cur index "p" by 1 from the prev index position
                    break;
                }
                else{
                    res[p]=res[p-1];
                }
                    
            }


            for(int k=1;k<=p;k++){   //This logic checks for sell position
                int i=k,m=0;
                while(i<=p){
                    if(P[i-1]<P[i]){
                        if(m==s.length || s[m]==-1)
                            break;
                        m++;
                    }else if(P[i-1]>P[i]){
                        if(m==s.length || s[m]==1)
                            break;
                        m++;
                    }
                    i++;
                }
            
                if(i>p && m==s.length && res[p-1]>0){
                    res[p]=Math.max(res[p],res[p-1])-1;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // Driver function

        // Test case 1
        int[] P={51,56,56,58,60,59,54,57,52,48};
        int[] b={1,1};
        int[] s={-1,-1,1};

        //Test case 2
        /*int[] P={26,28,34,16,28,87};
        int[] b={1,1};
        int[] s={-1};*/
        
        Stock s=new Stock();
        int[] res=s.stock(P,b,s);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
        System.out.println();
    }
}
