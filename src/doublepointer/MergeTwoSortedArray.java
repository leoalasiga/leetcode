package doublepointer;

import java.util.Arrays;

/**
 * @description: 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * @author: liujiajie
 * @date: 2023/12/5 19:14
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge2(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }


    }

    /**
     * 最直观的方法是先将数组 nums2
     * 放进数组 nums1
     * 的尾部，然后直接对整个数组进行排序。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    /**
     * 利用数组 nums1与 nums2已经被排序的性质,为了利用这一性质，我们可以使用双指针方法。
     * 这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。
     * 相当于，新写一个数组sort
     * 然后两个指针p1，p2
     * 从两个数组取数字，比较这个位数的大小，
     * 然后看大小，选择哪个指针右移一位
     * 从而实现排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sort = new int[n + m];
        for (int i = 0; i < sort.length; i++) {
            if (p1 == m && p2 != n) {
                sort[i] = nums2[p2];
                p2++;
                continue;
            }

            if (p2 == n && p1 != m) {
                sort[i] = nums1[p1];
                p1++;
                continue;
            }

            if (nums1[p1] > nums2[p2]) {
                sort[i] = nums2[p2];
                p2++;

            } else {
                sort[i] = nums1[p1];
                p1++;

            }
        }

        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
    }


    /**
     * 也是双指针的方式，但是这次，不用新的数组了，用逆向双指针，利用nums数组后面几位是空的情况，实现排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m == -1 && n != -1) {
                nums1[i] = nums2[n];
                n--;
                continue;
            }

            if (n == -1 && m != -1) {
                nums1[i] = nums1[m];
                m--;
                continue;
            }

            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }


        }
    }

}
