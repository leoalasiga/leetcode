package basic;

/**
 * 通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
 * 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移
 * 动一位。这种算法叫做插入排序，实现请见算法 2.2。
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2023/11/15 下午5:04
 */
public class InsertSort {

    public static void insertSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                //循环这张牌之前的牌，如果这张牌的前一张比他大，就交换位置，一直到牌头
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j-1] = tmp;
            }
        }

    }

    /**
     * gpt写的版本有点难理解的
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //先拿到当前这张牌
            int key = nums[i];
            //然后拿前一张牌的序列
            int j = i - 1;
            //如果前面右牌，并且前面一张牌比现在的大
            while (j >= 0 && nums[j] > key) {
                //那就将前面一张牌向右边放
                nums[j + 1] = nums[j];
                //然后再往前面一张牌看，看看前面一张牌大还是后年一张牌大，以此类推，一直找到这张牌前面比后一张小的位置
                j = j - 1;
            }
            //将这张牌放到那个位置
            nums[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 5, 8};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int[] nums2 = {1, 3, 5, 7, 2, 5, 8};
        insertSort2(nums2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}
