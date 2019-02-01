package xiyou.mc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
//        System.out.print("sss");
        int[] a = new int[]{0, 2, 3, 4, 5, 6};
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
//        System.out.println(multiply("12", "11"));
//        System.out.print(Math.pow(10, 2));
//        print(reverseWords(" i    am   a       mac"));
//        print(simplifyPath("/home/"));

        final ThreadLocal<String> stringThreadLocal = new InheritableThreadLocal<>();
        stringThreadLocal.set("aaaa");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                stringThreadLocal.set(stringThreadLocal.get() + "b");

                stringThreadLocal.set(stringThreadLocal.get() + "b");
                System.out.println(Thread.currentThread().getId() + " " + stringThreadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                stringThreadLocal.set(stringThreadLocal.get() + "c");
                System.out.println(Thread.currentThread().getId() + " " + stringThreadLocal.get());
            }
        }).start();

        stringThreadLocal.set("dddd");
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//
//        }
//    }

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
            stringBuilder.append(new String(s).substring(i, j)).append(" ");
            i = j;
        }

        return stringBuilder.toString();
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


    public static String multiply(String num1, String num2) {
        String multi = "";

        return String.valueOf(multiAdd(num1) * multiAdd(num2));
    }

    private static int multiAdd(String num) {
        int num1Int = 0;
        HashMap<Character, Integer> numbMap = new HashMap<Character, Integer>() {
            {
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
            }
        };
        int index = num.length();

        for (char s : num.toCharArray()) {
            //每一个分解之后的值相加， 然后乘以  num2 的值
            index -= 1;
            num1Int += Math.pow(10, index) * numbMap.get(s);
        }
        return num1Int;
    }

    public static void checkInclusion(String s1, String s2) {
        permutation(s1, 0, s1.length() - 1, s2);
    }

    private static boolean permutation(String s, int from, int to, String s2) {
        if (to <= 1) {
            return false;
        }
        boolean isHas = false;
        char[] ch = s.toCharArray();
        if (from == to) {
            System.out.println(s);
//            if (s2.contains(s)) {
//                isHas = true;
//            }
        } else {
            for (int i = from; i <= to; i++) {
                boolean isRe = false;
                //与后面不重复的字符作交换
                for (int j = from; j < i; j++) {
                    System.out.println(ch[j] + "-----》" + ch[i]);
                    if (ch[j] == ch[i]) {

                        isRe = true;
                    }
                }
                if (isRe) {
                    continue;
                }
                swap(ch, i, from);
                permutation(new String(ch), from + 1, to, s2);
                swap(ch, from, i);
            }
        }
        return isHas;
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder maxPreStr = new StringBuilder();
        for (char s : strs[0].toCharArray()) {
            boolean isAllHasS = true;
            for (String str : strs) {
                if (str.indexOf(s) == -1) {
                    isAllHasS = false;
                }
            }
            if (isAllHasS) {
                maxPreStr.append(s);
            }
        }
        return maxPreStr.toString();
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
}
