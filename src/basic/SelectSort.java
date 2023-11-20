package basic;

/**
 * 一种最简单的排序算法是这样的：首先，找到数组中最小的那个元素，其次，将它和数组的第
 * 一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。再次，在剩下的元素中
 * 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法
 * 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2023/11/15 下午4:15
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 5, 8};
        selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void selectSort(int[] nums) {
        // 将nums[]按升序排列
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            //选出最小值
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            //然后和现在这位置交换
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }
}
