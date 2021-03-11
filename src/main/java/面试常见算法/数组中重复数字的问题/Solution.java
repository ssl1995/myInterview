package 面试常见算法.数组中重复数字的问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = findDuplicates(arr);
        System.out.println(res);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        if (nums == null | length == 0) {
            return null;
        }
        List<Integer> ret = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            int index = (nums[i] - 1) % length;//是为了保证得到一个小于length的数组索引
            nums[index] += length;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 2 * length) {//证明该位置的值出现过两次
                ret.add(i + 1);//i+1代表的是该位置应该存在的值，而不是数组中该位置的实际值
            }
        }
        return ret;
    }
}
