package leetcode;

class solution {
    public int removeDuplicates(int[] nums) {
       int len = nums.length;
       int j = 0;
       for(int i = 0; i < len; i++){
           if(i == 0 || nums[i] != nums[j - 1]){
               nums[j] = nums[i];
               j++;
           }
       }
       return j;
    }

    public static void main(String[] args) {
        int[] nums =new int[] {1,1,2};
        System.out.println(new solution().removeDuplicates(nums));
    }
}
