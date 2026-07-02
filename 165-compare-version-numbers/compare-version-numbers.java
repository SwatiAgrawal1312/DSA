class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int l=Math.max(v1.length,v2.length);
        for(int i=0;i<l;i++){
            int x=i>=v1.length?0:Integer.parseInt(v1[i]);
            int y=i>=v2.length?0:Integer.parseInt(v2[i]);
            if(x<y){
                return -1;
            }
            else if(x>y){
                return 1;
            }
        }
        return 0;

        
    }
}