class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorsum=0;
        for(int num:nums){
            xorsum=xorsum^num;
        }
        for(int i=0;i<=n;i++){
            xorsum=xorsum^i;
        }
    return xorsum;
    }
}



    //     int expected = n * (n + 1) / 2;
    //     int actual = 0;

    //     for(int num : nums) {
    //         actual += num;
    //     }

    //     return expected - actual;
    // }
