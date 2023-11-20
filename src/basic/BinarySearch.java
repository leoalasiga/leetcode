package basic;

/**
 * 二分查找
 * 数组必须是有序的
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2023/11/15 下午3:56
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(4, nums));
        System.out.println(binarySearch(2, nums));
        System.out.println(binarySearch(6, nums));
        System.out.println(binarySearch(0, nums));
    }

    public static int binarySearch(int key, int[] nums) {
        //数组必须是有序的
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) {
                hi = mid - 1;
            } else if (key > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

}
