package basic;

/**
 * 排序算法类的模板
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2023/11/15 下午4:18
 */
public class Example {
    /**
     * 具体实现依据具体排序算法决定
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否升序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
