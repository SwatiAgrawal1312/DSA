class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        
        int[] hori=new int[hFences.length+2];
        int[] vert=new int[vFences.length+2];
        hori[0]=1;
        hori[hori.length-1]=m;
        
        for(int i=0;i<hFences.length;i++){
            hori[i+1]=hFences[i];
        }
        vert[0]=1;
        vert[vert.length-1]=n;
        for(int i=0;i<vFences.length;i++){
            vert[i+1]=vFences[i];
        }
        Arrays.sort(hori);
        Arrays.sort(vert);

        Set<Integer> hs=new HashSet<>();
       
        for(int i=0;i<hori.length;i++){
            for(int j=i+1;j<hori.length;j++){
                hs.add(hori[j]-hori[i]);
            }
        }
        long maxside=0;
        for(int i=0;i<vert.length;i++){
            for(int j=i+1;j<vert.length;j++){
               int val=vert[j]-vert[i];
               if(hs.contains(val)){
                maxside=Math.max(maxside,val);
               }
            }
        }
        if(maxside==0){
            return -1;
        }
        return (int)((maxside*maxside)%1000000007);
       

        
    }
}