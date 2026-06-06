class Solution {
    public int reversePairs(int[] nums) {
        return (int)merge(nums,0,nums.length-1);
        
    }
    public long merge(int[] nums,int si,int ei){
        if(si>=ei){
            return 0;
        }
        int mid=si+(ei-si)/2;
        long left=merge(nums,si,mid);
        long right=merge(nums,mid+1,ei);
        long ans=mergesort(nums,si,mid,ei);
        return left+right+ans;

    }
    public long mergesort(int nums[],int si,int mid,int ei){
        int i=si;
        int j=mid+1;
        long count=0;
        while(i<=mid && j<=ei){
            if((long)nums[i]>(long)2*nums[j]){
                count+=mid-i+1;
                j++;
            }else{
                i++;
            }
        }
        i=si;
        j=mid+1;
        int k=0;
        int temp[]=new int[ei-si+1];
        while(i<=mid && j<=ei){
            if(nums[i]<=nums[j]){
                temp[k]=nums[i];
                k++;
                i++;
            }else{
                temp[k]=nums[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
             temp[k]=nums[i];
                k++;
                i++;

        }
        while(j<=ei){
            temp[k]=nums[j];
                k++;
                j++;

        }
        for(i=si,k=0;k<temp.length;i++,k++){
            nums[i]=temp[k];
        }
        return count;
    }
}