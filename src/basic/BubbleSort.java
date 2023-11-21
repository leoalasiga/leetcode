package basic;

/**
 * 冒泡排序
 * 冒泡排序就像在水中冒泡一样，较小的气泡逐渐上浮到水面，较大的气泡则沉向底部。在排序过程中，数组中的元素就像水中的气泡一样，通过不断比较和交换，逐渐按照大小顺序浮动到正确的位置。
 * <p>
 * 具体过程可以描述如下：
 * <p>
 * 从数组的起始位置开始，比较相邻的两个元素。
 * 如果顺序不对（即前一个元素大于后一个元素），则交换它们的位置。
 * 继续向数组的下一对相邻元素进行比较和交换，直到达到数组的末尾。
 * 一次遍历完成后，数组中最大的元素就像气泡一样浮到了最右侧。
 * 重复上述步骤，但忽略已经排序好的最后一个元素，直到整个数组有序。
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2023/11/21 上午9:04
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        //重复上述步骤，但忽略已经排序好的最后一个元素，直到整个数组有序。
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                //从数组的起始位置开始，比较相邻的两个元素。
                if (nums[j] > nums[j + 1]) {
                    //如果顺序不对（即前一个元素大于后一个元素），则交换它们的位置。
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
            // 一次遍历完成后，数组中最大的元素就像气泡一样浮到了最右侧。相当于下一次要排序的数组数量要少一次（所以要-i）
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 7, 2, 5, 8};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
