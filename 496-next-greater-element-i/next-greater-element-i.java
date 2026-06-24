class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            boolean element=false;
            int nextgreater=-1;
           
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    element=true;
                }
                if(element && nums2[j]>nums1[i]){
                    nextgreater=nums2[j];
                    break;
                }   
            }
            result[i]=nextgreater;

        }
        return result;
       

    }
}