package xiyou.mc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));

        char[][] s = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        maximalSquare(s);
        System.out.println('1' - '0');
//        System.out.print("sss");
//        int[] a = new int[]{0, 2, 3, 4, 5, 6};
//        System.out.println(minSubSum(a, 0, a.length - 1));

//        System.out.println(gdc(10, 5));
//        System.out.println(a215(a, 0, a.length - 1, 1));
//        String b = "a";
//        String c = "a";
//        System.out.println((b == c) + " " + b.hashCode() + " " + c.hashCode());
//        System.out.print(lengthOfLongestSubstring("aaaaabcadcgfhaa"));
//        System.out.println(longestCommonPrefix(new String[]{
//                "dog", "racecar", "car"
//        }));

//        checkInclusion("bab", "abc");
        System.out.println(

                multiply("123456789", "987654321"));

        //        System.out.print(Math.pow(10, 2));
        print(reverseWords(" i    am   a       mac"));
//        print(simplifyPath("/home/"));

//        final ThreadLocal<String> stringThreadLocal = new InheritableThreadLocal<>();
//        stringThreadLocal.set("aaaa");
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                }
//                stringThreadLocal.set(stringThreadLocal.get() + "b");
//
//                stringThreadLocal.set(stringThreadLocal.get() + "b");
//                System.out.println(Thread.currentThread().getId() + " " + stringThreadLocal.get());
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
//                stringThreadLocal.set(stringThreadLocal.get() + "c");
//                System.out.println(Thread.currentThread().getId() + " " + stringThreadLocal.get());
//            }
//        }).start();
//
//        stringThreadLocal.set("dddd");

        int[] ints = {-1, 0, 1, 2, -1, -4};
        // -4 -1 -1 0 1 2
        System.out.println(

                threeSum(ints));

        int[] i = {5, 1, 2, 3, 4};
        System.out.println(" search->>>" +

                search(i, 1));


        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(

                findKthLargest(a, 4));


        int[] b = {100, 4, 200, 1, 3, 2};
        System.out.println(

                longestConsecutive(b));

        int[][] m = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(

                findCircleNum(m));

        int[] t = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(

                trap(t));
        int[] p = {5, 2, 1, 3, 6, 9, 8, 0, 4, 10, 20, 11};

//        shellsort(p);
        mergeSort(p);
        System.out.println("归并排序");
        for (

                int pp : p)

        {
            System.out.print(pp + "");
        }


        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);

        System.out.println("--------!!" + lruCache.get(1));
        System.out.println("--------!!" + lruCache.get(2));
        strSort("aabc");
    }

    //三数之和
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //以i为基准
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int left = i + 1, high = nums.length - 1, rightSum = 0 - nums[i];
                while (left < high) {
                    if (nums[left] + nums[high] == rightSum) {
                        lists.add(Arrays.asList(nums[left], nums[i], nums[high]));
                        while (left < high && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        left++;
                        high--;
                    } else if (nums[left] + nums[high] < rightSum) {
                        left++;
                    } else {
                        high--;
                    }
                }
            }

        }
        return lists;
    }

    //搜索旋转排序数组
    // 45123   45678  ->  78456
    //nums = [4,5,0,1,2], target = 0
    // 5 1 2 3 4    center -> 2
    //输出: 4

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int center = (left + right) / 2;
            if (nums[center] == target) {
                return center;
            }

            if (nums[left] <= nums[center]) {
                if (nums[center] > target && nums[left] <= target) {
                    right = center - 1;
                } else {
                    left = center + 1;
                }
            } else {

                if (nums[right] < target || target <= nums[center]) {
                    right = center - 1;
                } else {
                    left = center + 1;
                }
            }
        }

        return -1;
    }

    //数组中的第K个最大元素
    private static int findKthLargest(int[] nums, int k) {

        //快排思想，从高到低， 之后右边的刚好为 k-1 ，则右边第一个为第k大元素
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int i = low;
            int j = high - 1;
            int pivot = nums[low];
            while (i <= j) {
                while (i <= j && nums[i] >= pivot) {
                    i++;
                }
                while (i <= j && nums[j] < pivot) {
                    j--;
                }
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }
            //替换中间值到 j
            nums[low] = nums[j];
            nums[j] = pivot;

            System.out.println("----" + pivot);
            if (j == k - 1) {
                for (int a = 0; a < nums.length; a++) {
                    System.out.print(nums[a]);
                }
                System.out.println();
                return nums[j];
            } else if (j > k - 1) {
                high = j;
            } else {
                low = j + 1;
            }
        }
        return -1;

    }

    //最长连续序列
    //[100, 4, 200, 1, 3, 2]

    // 100 -> 1 4->2 200->1 1->1 3->2 2->
    private static int longestConsecutive(int[] nums) {

        //通过 增加 o=O(n) hashmap ，分成左右两个序列， 中间值为left+right +1
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (!map.containsKey(i)) {
                int left = map.getOrDefault(i - 1, 0);
                int right = map.getOrDefault(i + 1, 0);
                int currentIMax = left + right + 1;
                map.put(i, currentIMax);

                //由于这一整段序列中，只可能在左右两端扩展，所以只需要更新左右两端的value值即可
                if (left != 0) {
                    // 最左端的value 更新为长度
                    map.put(i - left, currentIMax);
                }
                if (right != 0) {
                    // 最右端的value 更新为长度
                    map.put(i + right, currentIMax);
                }
                max = Math.max(max, currentIMax);
            }
        }
        return max;
    }

    /**
     * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
     * <p>
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [[1,1,0],
     * [1,1,0],
     * [0,0,1]]
     * 输出: 2
     * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
     * 第2个学生自己在一个朋友圈。所以返回2。
     * 示例 2:
     * <p>
     * 输入:
     * [[1,1,0],
     * [1,1,1],
     * [0,1,1]]
     * 输出: 1
     * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
     * 注意：
     * <p>
     * N 在[1,200]的范围内。
     * 对于所有学生，有M[i][i] = 1。
     * 如果有M[i][j] = 1，则有M[j][i] = 1。
     *
     * @param path
     * @return
     */


    //使用 DFS  和 BFS 遍历 A 的朋友，以及 A 朋友的朋友。同时循环遍历下去
    private static int findCircleNum(int[][] M) {
        int circleNum = 0;
        boolean[] isVisited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
//                DFS(M, i, isVisited);
                Queue<Integer> queue = new LinkedList<>();
                ((LinkedList<Integer>) queue).add(i);
                BFS(M, isVisited, queue);
                circleNum++;
            }
        }
        return circleNum;
    }

    private static void DFS(int[][] M, int k, boolean[] isVisited) {
        isVisited[k] = true;
        for (int i = 0; i < M.length; i++) {
            if (M[k][i] == 1 && !isVisited[i]) {
                DFS(M, i, isVisited);
            }
        }
    }

    private static void BFS(int[][] M, boolean[] isVisited, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int k = queue.poll();
            isVisited[k] = true;
            for (int i = 0; i < M.length; i++) {
                if (M[k][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    /**
     *合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]k
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * @param path
     * @return
     */

    /**
     * 接雨水
     */
    //左右两个指针，找到局部最高点，只有有比最高点小的就能装水
    private static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int area = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                if (leftMax > height[left]) {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    area += rightMax - height[right];
                }
                right--;
            }
        }
        return area;
    }

    public static String simplifyPath(String path) {

        ArrayList<String> special = new ArrayList<String>() {
            {
                add(".");
                add("..");
                add("");
            }
        };
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (!special.contains(p)) {
                stack.push(p);
            } else {
                if ("..".equals(p) && !stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        for (String s : stack) {
            stringBuilder.append("/").append(s);
        }
        return stringBuilder.toString();
    }

    public static String reverseWords(String s) {
        return reverseWords(s.toCharArray(), 0, s.length() - 1);

    }

    private static String reverseWords(char[] s, int begin, int end) {
        swapWord(s, begin, end);
        //去除多余空格
        print(new String(s));
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length) {
            while (i < s.length && Character.isSpaceChar(s[i])) {
                i++;
            }
            if (i == s.length) {
                break;
            }
            j = i;
            while (j < s.length && !Character.isSpaceChar(s[j])) {
                j++;
            }
            print(i + "-----" + j);
            char[] word = new String(s).substring(i, j).toCharArray();
            swapWord(word, 0, word.length - 1);
            stringBuilder.append(new String(word)).append(" ");
            i = j;
        }

        return stringBuilder.toString().trim();
    }

    private static void print(String msg) {
        System.out.println(msg);
    }

    private static void swapWord(char[] s, int begin, int end) {
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }


//    public static String multiply(String num1, String num2) {
//        String multi = "";
//
//        return String.valueOf(multiAdd(num1) * multiAdd(num2));
//    }
//
//    private static int multiAdd(String num) {
//        int num1Int = 0;
//        HashMap<Character, Integer> numbMap = new HashMap<Character, Integer>() {
//            {
//                put('0', 0);
//                put('1', 1);
//                put('2', 2);
//                put('3', 3);
//                put('4', 4);
//                put('5', 5);
//                put('6', 6);
//                put('7', 7);
//                put('8', 8);
//                put('9', 9);
//            }
//        };
//        int index = num.length();
//
//        for (char s : num.toCharArray()) {
//            //每一个分解之后的值相加， 然后乘以  num2 的值
//            index -= 1;
//            num1Int += Math.pow(10, index) * numbMap.get(s);
//        }
//        System.out.println(num1Int);
//        return num1Int;
//    }
//
//    public static void checkInclusion(String s1, String s2) {
//        permutation(s1, 0, s1.length() - 1, s2);
//    }
//
//    private static boolean permutation(String s, int from, int to, String s2) {
//        if (to <= 1) {
//            return false;
//        }
//        boolean isHas = false;
//        char[] ch = s.toCharArray();
//        if (from == to) {
//            System.out.println(s);
////            if (s2.contains(s)) {
////                isHas = true;
////            }
//        } else {
//            for (int i = from; i <= to; i++) {
//                boolean isRe = false;
//                //与后面不重复的字符作交换
//                for (int j = from; j < i; j++) {
//                    System.out.println(ch[j] + "-----》" + ch[i]);
//                    if (ch[j] == ch[i]) {
//
//                        isRe = true;
//                    }
//                }
//                if (isRe) {
//                    continue;
//                }
//                swap(ch, i, from);
//                permutation(new String(ch), from + 1, to, s2);
//                swap(ch, from, i);
//            }
//        }
//        return isHas;
//    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    private static void swap(int[] ch, int i, int j) {
        int temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!prefix.isEmpty() && strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
//        StringBuilder maxPreStr = new StringBuilder();
//        for (char s : strs[0].toCharArray()) {
//            boolean isAllHasS = true;
//            for (String str : strs) {
//                if (str.indexOf(s) == -1) {
//                    isAllHasS = false;
//                }
//            }
//            if (isAllHasS) {
//                maxPreStr.append(s);
//            }
//        }
//        return maxPreStr.toString();
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() < 1)
            return 0;

        int max = 1;
        int pre = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer lastIndex = map.get(str.charAt(i));
            if (lastIndex != null) {
                pre = Math.max(pre, lastIndex);
            }
            max = Math.max(max, i - pre);
            map.put(str.charAt(i), i);
        }
        return max;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1) {
//            return 1;
//        } else if (s.length() == 0) {
//            return 0;
//        }
//        int maxLength = 1;
//
//        LinkedList<Character> queue = new LinkedList<>();
//        for (char i : s.toCharArray()) {
//            if (queue.isEmpty()) {
//                queue.add(i);
//            }
//            int indexOf = queue.indexOf(i);
//            boolean isHas = indexOf != -1;
//            if (maxLength < queue.size()) {
//                maxLength = queue.size();
//            }
//            if (isHas) {
//                for (int index = 0; index <= indexOf; index++) {
//                    queue.poll();
//                }
//            }
//            queue.add(i);
//        }
//        return maxLength;
//
////        System.out.println("--------");
////        for (Character c : queue) {
////            System.out.println(c);
////        }
//
////        Stack<Character> stack = new Stack<Character>();
////        for (char i : s.toCharArray()) {
////            if (stack.isEmpty()) {
////                stack.push(i);
////                continue;
////            }
////            boolean isHasEd = stack.search(i) != -1;
////
////            if (isHasEd) {
////                if (maxLength < stack.size()) {
////                    maxLength = stack.size();
////                }
////                stack.clear();
////                stack.push(i);
////            } else {
////                stack.push(i);
////            }
////        }
////        for (char i : stack) {
////            System.out.print(i);
////        }
////        return maxLength;
//    }


    private static boolean a215(int[] a, int left, int right, int i) {
        if (left == right) {
            if (a[left] == i) {
                System.out.println(left);
                return true;
            } else {
                return false;
            }
        }

        boolean isHas;
        int center = (left + right) / 2;
        if (a[center] == i) {
            System.out.println(center);
            return true;
        }
        if (i <= center) {
            isHas = a215(a, left, center, i);
        } else {
            isHas = a215(a, center + 1, right, i);
        }

        return isHas;

    }


    private static long gdc(long a, long b) {
        boolean aIsEven = a % 2 == 0;
        boolean bIsEvent = b % 2 == 0;

//        if (!aIsEven && bIsEvent) {
//            a = 2 * a;
//        }
        while (b != 0) {
            long rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    /**
     * 最大子序列
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int maxSubSum(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
//        System.out.println(center);
        int maxLeftSub = maxSubSum(a, left, center);
        int maxRightSub = maxSubSum(a, center + 1, right);
        int maxBorderRightSum = 0;
        int maxBordrRight = 0;
        for (int i = center + 1; i <= right; i++) {
            maxBorderRightSum += a[i];
            if (maxBorderRightSum > maxBordrRight) {
                maxBordrRight = maxBorderRightSum;
            }
        }

        int maxBorderLeftSum = 0;
        int maxBordrLeft = 0;
        for (int j = center; j >= left; j--) {
            maxBorderLeftSum += a[j];
            if (maxBorderLeftSum > maxBordrLeft) {
                maxBordrLeft = maxBorderLeftSum;
            }
        }


        int maxSub = 0;
        if (maxLeftSub > maxRightSub) {
            maxSub = maxLeftSub;
        } else {
            maxSub = maxRightSub;
        }

        return maxSub > (maxBordrLeft + maxBordrRight) ? maxSub : (maxBordrLeft + maxBordrRight);
    }


    /**
     * 最小子序列
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int minSubSum(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] >= 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int minSubLeftSum = minSubSum(a, left, center);
        int minSubRightSum = minSubSum(a, center + 1, right);

        /**
         * 计算 附加 中间值的 最小子序列
         */

        int minBorderSubLeftSum = 0;
        int minBorderSubLeft = 0;
        for (int i = center; i >= left; i--) {
            minBorderSubLeftSum += a[i];
            if (minBorderSubLeftSum < minBorderSubLeft) {
                minBorderSubLeft = minBorderSubLeftSum;
            }
        }


        int minBorderSubRightSum = 0;
        int minBorderSubRight = 0;
        for (int j = center + 1; j <= right; j++) {
            minBorderSubRightSum += a[j];
            if (minBorderSubRightSum < minBorderSubRight) {
                minBorderSubRight = minBorderSubRightSum;
            }
        }

        int minSub = minSubLeftSum < minSubRightSum ? minSubLeftSum : minSubRightSum;
        int bordSum = minBorderSubLeft + minBorderSubRight;
        return minSub < bordSum ? minSub : bordSum;
    }


    /**
     * 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * 1->2->4,
     * 1->3->4
     * 1 ->  ( 2->4 1->3->4 )
     * <p>
     * 输出：1->1->2->3->4->4
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }
        ListNode mergeList = new ListNode(Math.min(l1.val, l2.val));
        if (l1.val <= l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        mergeList.next = mergeTwoLists(l1, l2);
        return mergeList;
//        while (l1 != null || l2 != null) {
//            if (l1 == null) {
//                mergeList.next = new ListNode(l2.val);
//                l2 = l2.next;
//            } else if (l2 == null) {
//                mergeList.next = new ListNode(l1.val);
//                l1 = l1.next;
//            } else {
//                if (l1.val < l2.val) {
//                    mergeList.next = new ListNode(l1.val);
//                    l1 = l1.next;
//                } else {
//                    mergeList.next = new ListNode(l2.val);
//                    l2 = l2.next;
//                }
//            }
//        }

    }

    /**
     * 翻转链表
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        ListNode r;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    /**
     * 1->2->3->4<-5       1->2->3<-4<-5
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tailNodeList = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return tailNodeList;
    }

    /**
     * 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * [0]
     * [7,3]
     * <p>
     * [9,9]
     * [9]
     * <p>
     * [8,9,9]
     * [2]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        }
        //两数相加
        int sum = l1.val + l2.val;
        //判断和是否大于10
        if (sum >= 10) {
            //大于10 判断 l1 的next 是否为空，为空则创建 1 ，不为空 则对next 进1
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val += 1;
            }
            //当前节点的值为 差
            l1.val = sum - 10;
        } else {
            l1.val = sum;
        }
        //对两个列表未对其的进行补 0，直到两个 next 都为 null 则终止
        if (l1.next == null && l2.next != null) {
            l1.next = new ListNode(0);
        } else if (l1.next != null && l2.next == null) {
            l2.next = new ListNode(0);
        }
        //next 为相加之后的节点
        l1.next = addTwoNumbers(l1.next, l2.next);
        return l1;
    }

    /**
     * 合并K个排序链表
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

//    public ListNode mergeKLists(ListNode[] lists) {
//
//    }

    /**
     * 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * <p>
     * 示例1:
     * <p>
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * <p>
     * <p>
     * 示例2:
     * <p>
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * <p>
     * <p>
     * 注意：
     * <p>
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     */

    public boolean checkInclusion(String s1, String s2) {
        //判断鲁棒性
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        //使用 窗口移动 来做。一共 26 个字母可以通过使用 26 大小的int 数组来记录 以 s1 为区间的字母的次数
        int[] ls1 = new int[26];
        int[] ls2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ls1[s1.charAt(i) - 'a']++;
            ls2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (isSame(ls1, ls2)) {
                return true;
            }
            ls2[s2.charAt(i - s1.length()) - 'a']--;
            ls2[s2.charAt(i) - 'a']++;
        }
        return isSame(ls1, ls2);
    }

    private boolean isSame(int[] s1, int[] s2) {
        for (int i = 0; i < s2.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }


    private static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }

    /**
     * 根据中序和前序 构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static BinaryTree BinariTreeNode(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return bri(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static BinaryTree bri(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        int root = preorder[ps];
        //find root in inorder
        int index = is;
        while (index <= ie && inorder[index] != root) {
            index++;
        }
        if (index > ie) {
            throw new RuntimeException("invalid num!");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.value = root;
        binaryTree.left = bri(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        binaryTree.right = bri(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return binaryTree;
    }

    /**
     * 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * <p>
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        // 创建一个大小为 n + m 的一维数组 ， 对两个数据进行从而向前遍历，数字1 的 第 i 位 * 数字2 的第 j 位 影响数组的 i+ j+ 1位， 同时需要增加 carry 来保存进位
        int[] num = new int[num1.length() + num2.length()];
        int carry = 0, product = 0, i = 0, j = 0;
        for (i = num1.length() - 1; i >= 0; i--) {
            carry = 0;
            for (j = num2.length() - 1; j >= 0; j--) {
                product = carry + (int) (num1Char[i] - '0') * (int) (num2Char[j] - '0') + num[i + j + 1];
                num[i + j + 1] = product % 10;
                carry = product / 10;
            }
            //一轮完成之后，最前面的一位
            num[i + j + 1] = carry;
        }

        i = 0;
        //去除最前是 0 的情况
        while (i < num.length && num[i] == 0) {
            i++;
        }

        //打印
        StringBuilder stringBuilder = new StringBuilder();
        while (i < num.length) {
            stringBuilder.append(num[i]);
            i++;
        }
        return stringBuilder.toString();
    }


    //插入排序
    private static void insertSort(int[] p) {
        if (p == null || p.length == 0) {
            return;
        }

        int j;
        for (int i = 1; i < p.length; i++) {
            int temp = p[i];
            for (j = i; j >= 0 && temp < p[j - 1]; j--) {
                p[j] = p[j - 1];
            }
            p[j] = temp;
        }
    }

    //{5, 2, 1, 3, 6};
    //快速排序
    private static void quicksort(int[] p, int low, int height) {
        if (low <= height) {
            int pivot = p[low];
            int i = low + 1;
            int j = height;
            for (; ; ) {
                while (i <= j && p[i] < pivot) {
                    ++i;
                }
                while (i <= j && p[j] > pivot) {
                    --j;
                }
                if (i < j) {
                    swap(p, i, j);
                    i++;
                    j--;
                } else {
                    break;
                }
            }
            swap(p, low, j);
            System.out.println("-!!!!---" + pivot + " low:" + low + " i:" + i + " j:" + j);
            for (int s : p) {
                System.out.print(s + "");
            }
            System.out.println();
            quicksort(p, low, j - 1);
            quicksort(p, j + 1, height);
        }
    }

    private static void shellsort(int[] p) {
        for (int gap = p.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < p.length; i++) {
                int temp = p[i];
                int j = i;
                for (; j >= gap && p[j] < p[j - gap]; j -= gap) {
                    p[j] = p[j - gap];
                }
                p[j] = temp;

            }
        }
    }

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

//    public ListNode sortList(ListNode head) {
//
//    }

    /**
     * 二叉树的锯齿形层次遍历
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int height = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if (height % 2 == 0) {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    if (node != null) {
                        stack1.push(node.right);
                        stack1.add(node.left);
                        list.add(node.val);
                    }
                }

            } else {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    if (node != null) {
                        stack2.push(node.left);
                        stack2.push(node.right);
                        list.add(node.val);
                    }

                }
            }
            if (!list.isEmpty()) {
                lists.add(list);
                height++;
            }
        }
        return lists;
    }

    /**
     * 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //算出股票的价格变动
        int[] biandong = new int[prices.length - 1];
        for (int i = 0; i < biandong.length; i++) {
            biandong[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int temp = 0;
        for (int j : biandong) {
            if (temp + j > 0) {
                temp += j;
            } else {
                temp = 0;
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        //分支 对 前半部分和后半部分分别求最大子序列。 最后对中间位置进行求解
        if (nums.length == 1) {
            return nums[0];
        }
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int center = (left + right) / 2;
        int maxLeft = maxSubArray(nums, left, center);
        int maxRight = maxSubArray(nums, center + 1, right);
        int maxLeftBorder = nums[center];
        int temp = 0;
        for (int i = center; i >= left; i--) {
            temp += nums[i];
            if (temp > maxLeftBorder) {
                maxLeftBorder = temp;
            }
        }

        temp = 0;
        int maxRightBorder = nums[center + 1];
        for (int i = center + 1; i <= right; i++) {
            temp += nums[i];
            if (temp > maxRightBorder) {
                maxRightBorder = temp;
            }
        }
        return Math.max(Math.max(maxLeft, maxRight), maxLeftBorder + maxRightBorder);
    }

    /**
     * 最大正方形
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * 输出: 4
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        //第一列
        int[][] p = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            p[i][0] = matrix[i][0] - '0';
            max = Math.max(max, p[i][0]);
        }

        //第一行
        for (int i = 0; i < colLength; i++) {
            p[0][i] = matrix[0][i] - '0';
            max = Math.max(max, p[0][i]);
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                p[i][j] = matrix[i][j] == '1' ? Math.min(p[i - 1][j], Math.min(p[i - 1][j - 1], p[i][j - 1])) + 1 : 0;
                max = Math.max(max, p[i][j]);
            }
        }
        return max * max;
    }

    /**
     * 最小栈
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */

    /**
     * initialize your data structure here.
     */
    public class MinStack {
        //保存与 min 的差值
        private Stack<Integer> s = new Stack<>();
        private int min;

        public MinStack() {

        }

        public void push(int x) {
            if (s.isEmpty()) {
                min = x;
                s.push(0);
            } else {
                s.push(x - min);
                if (x < min) {
                    min = x;
                }
            }
        }

        public void pop() {
            if (s.isEmpty()) {
                return;
            }
            int pop = s.pop();
            if (pop < 0) {
                min = min - pop;
            }
        }

        public int top() {
            if (s.isEmpty()) {
                return -1;
            }
            int peek = s.peek();
            if (peek > 0) {
                return peek + min;
            }
            return min;
        }

        public int getMin() {
            if (s.isEmpty()) {
                return 0;
            }
            return min;
        }
    }

    /**
     * LRU缓存机制
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * <p>
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
     * <p>
     * 进阶:
     * <p>
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     * <p>
     * 示例:
     * <p>
     * LRUCache cache = new LRUCache( 2 /* 缓存容量  );
     * <p>
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     */

    static class LRUCache {
        private class CacheNode {
            int value;
            CacheNode pre;
            CacheNode next;
            int key;
        }

        private HashMap<Integer, CacheNode> caches = new HashMap<>();
        private List<CacheNode> list = new LinkedList<>();
        private int count;

        public LRUCache(int capacity) {
            this.count = capacity;
        }

        public int get(int key) {
            CacheNode c = caches.get(key);
            if (c != null) {
                //只需要移动当前 key 到 链表头 即可
                //不在链表头
                if (c.pre != null) {
                    c.pre.next = c.next;
                    if (c.next != null) {
                        c.next.pre = c.pre;
                    }
                    c.pre = null;
                    c.next = list.get(0);
                    list.get(0).pre = c;
                    list.remove(c);
                    list.add(0, c);
                }
                return c.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            CacheNode c = caches.get(key);
            if (c != null) {
                c.value = value;
                if (c.pre != null) {
                    c.pre.next = c.next;
                    if (c.next != null) {
                        c.next.pre = c.pre;
                    }
                    c.pre = null;
                    c.next = list.get(0);
                    list.get(0).pre = c;
                    list.remove(c);
                    list.add(0, c);
                }

            } else {
                if (list.size() == count) {
                    CacheNode last = list.remove(count - 1);
                    if (last.pre != null) {
                        last.pre.next = null;
                    }
                    last.pre = null;
                    caches.remove(last.key);
                }
                CacheNode cacheNode = new CacheNode();
                cacheNode.value = value;
                cacheNode.key = key;
                if (!list.isEmpty()) {
                    cacheNode.next = list.get(0);
                    list.get(0).pre = cacheNode;
                }
                list.add(0, cacheNode);
                caches.put(key, cacheNode);
            }
        }
    }

//    public static class LRUCache {
//
//        private class CacheNode {
//            int value;
//            CacheNode pre;
//            CacheNode next;
//            int key;
//        }
//
//        private HashMap<Integer, CacheNode> caches = new HashMap<>();
//        private List<CacheNode> list = new LinkedList<>();
//        private int count;
//
//        public LRUCache(int capacity) {
//            this.count = capacity;
//        }
//
//        public int get(int key) {
//            CacheNode c = caches.get(key);
//            if (c != null) {
//                //只需要移动当前 key 到 链表头 即可
//                //不在链表头
//                if (c.pre != null) {
//                    list.remove(c);
//                    c.pre.next = c.next;
//                    if (c.next != null) {
//                        c.next.pre = c.pre;
//                    }
//                    c.pre = null;
//                    c.next = list.get(0);
//                    list.add(0, c);
//                }
//                return c.value;
//            } else {
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            CacheNode c = caches.get(key);
//            if (c != null) {
//                c.value = value;
//                if (c.pre != null) {
//                    list.remove(c);
//                    caches.remove(key);
//                    c.pre.next = c.next;
//                    if (c.next != null) {
//                        c.next.pre = c.pre;
//                    }
//                    c.pre = null;
//                    c.next = list.get(0);
//                    list.add(0, c);
//                }
//
//            } else {
//                if (list.size() == count) {
//                    CacheNode last = list.remove(count - 1);
//                    last.pre.next = null;
//                    last.pre = null;
//                    caches.remove(last.key);
//                }
//                CacheNode cacheNode = new CacheNode();
//                cacheNode.value = value;
//                cacheNode.key = key;
//                if (!list.isEmpty()) {
//                    cacheNode.next = list.get(0);
//                    list.get(0).pre = cacheNode;
//                }
//                list.add(0, cacheNode);
//                caches.put(key, cacheNode);
//            }
//        }
//    }

    private static void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;

            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);

            merge(a, temp, left, center + 1, right);
        }

    }

    private static void merge(int[] a, int[] temp, int left, int rightPos, int right) {
        //将两段数组 合并到 temp
        int leftEnd = rightPos - 1;
        int tempPos = left;
        int numSize = right - left + 1;
        while (left <= leftEnd && right >= rightPos) {
            if (a[left] > a[rightPos]) {
                temp[tempPos++] = a[rightPos++];
            } else {
                temp[tempPos++] = a[left++];
            }
        }
        while (left <= leftEnd) {
            temp[tempPos++] = a[left++];
        }
        while (right >= rightPos) {
            temp[tempPos++] = a[rightPos++];
        }
        for (int i = 0; i < numSize; i++, right--)
            a[right] = temp[right];
    }

    /**
     * 字符串全排列
     */

    private static void strSort(String p) {
        strSort(p.toCharArray(), 0, p.length());
    }

    private static void strSort(char[] p, int start, int end) {
        if (start == end) {
            System.out.println("全排列");
            for (char i : p) {
                System.out.print(i);
            }
        } else {
            for (int i = start; i < end; i++) {
                while (i < end - 1 && p[i] == p[i + 1]) {
                    i++;
                }
                swap(p, start, i);
                strSort(p, start + 1, end);
                swap(p, start, i);
            }
        }
    }

    /**
     * x 的平方根
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     */

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (right >= left) {
            int center = (left + right) / 2;
            int cheng = center * center;
            if (cheng > x) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        return left - 1;
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    private static void bubbleSort1(int[] nums) {
        int k = nums.length;
        boolean flag = true;//标识某一趟有交换
        while (flag) {
            flag = false;
            for (int j = 1; j < k; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            k--;
        }
    }
}
