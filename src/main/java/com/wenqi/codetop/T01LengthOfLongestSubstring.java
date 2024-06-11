package com.wenqi.codetop;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 *
 * @author Wenqi Liang
 * @date 2024/6/11
 */
public class T01LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aucdee";
        String s5 = "dvdf";


        print(s1);
        print(s2);
        print(s3);
        print(s4);
        print(s5);

    }

    private static void print(String str) {
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 执行用时分布 5 ms 击败  78.75%, 消耗内存分布 43.58 MB 击败 58.85%
     * <p>
     * 解题思路:
     * 1. 快慢指针, 用set存储已经检索数据
     * 2. 快指针指向重复数据时, 记录此时最大长度, 慢指针挪动到与快指针重复的数据, 并丢弃掉慢指针已经掠过的数据
     * 优化思路:
     * 快指针指向多个重复数据时, 快速略过
     */
    public static int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 1;
        int slow = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(slow));
        for (int i = 1; i < s.length(); i++) {
            char fastChar = s.charAt(i);
            if (set.contains(fastChar)) {
                max = Math.max(max, set.size());
                for (int j = slow; j < i; j++) {
                    if (s.charAt(j) == fastChar) {
                        slow = j + 1;
                        break;
                    } else {
                        set.remove(s.charAt(j));
                    }
                }
            }
            set.add(fastChar);
        }

        return Math.max(max, set.size());
    }
}
