public class HelloWorld {
    
    private int[] stock(int[] P,int[] b,int[] s){
        int[] res=new int[P.length];
        for(int i=0;i<res.length;i++)
            res[i]=0;
        
        for(int p=1;p<res.length;p++){
            for(int k=1;k<=p;k++){
                int i=k,m=0;
                while(i<=p){
                    if(P[i-1]<P[i]){
                        if(m==b.length)
                            break;
                        if(b[m]==-1)
                            break;
                        else
                            m++;
                    }else if(P[i-1]>P[i]){
                        if(m==b.length)
                            break;
                        if(b[m]==1)
                            break;
                        else
                            m++;
                    }
                    i++;
                }
                
                if(i>p && m==b.length){
                    System.out.println(k+" i "+i+" p "+p+" m "+m);
                    System.out.println("here");
                    res[p]=res[p-1]+1;
                    System.out.println(p+" "+res[p]+" "+res[p-1]);
                    break;
                }
                else{
                    System.out.println("here in else "+p);
                    res[p]=res[p-1];
                }
                    
            }
            for(int k=1;k<=p;k++){
                int i=k,m=0;
                while(i<=p){
                    if(P[i-1]<P[i]){
                        if(m==s.length)
                            break;
                        if(s[m]==-1)
                            break;
                        else
                            m++;
                    }else if(P[i-1]>P[i]){
                        if(m==s.length)
                            break;
                        if(s[m]==1)
                            break;
                        else
                            m++;
                    }
                    i++;
                }
            
            if(i>p && m==s.length && res[p-1]>0){
                System.out.println("i "+i+" p "+p+" m "+m);
                System.out.println("here sell");
                res[p]=Math.max(res[p],res[p-1])-1;
                break;
                //System.out.println("here sell");
            }
                
                /*else
                    res[p]=res[p-1];*/
            }
        }
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
        System.out.println();
        return res;
    }
    
    public static void main(String[] args) {
        //System.out.println("Hello, World!"); 
        /*int[] P={51,56,56,56,60,59,54,57,52,48};
        int[] b={1,1};
        int[] s={-1,-1,1};*/
        int[] P={26,28,34,16,28,87};
        int[] b={1,1};
        int[] s={-1};
        HelloWorld h=new HelloWorld();
        int[] res=h.stock(P,b,s);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
        System.out.println();
    }
}