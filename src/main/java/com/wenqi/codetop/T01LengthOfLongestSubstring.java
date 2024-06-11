package com.wenqi.codetop;

import java.util.HashMap;
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
     * 通义灵码的优化建议:
     * 执行用时分布 4 ms 击败  90.96%, 消耗内存分布 43.66 MB 击败 41.78%
     * <p>
     * 解题思路:
     * 1. 快慢指针, 使用HashMap存储已经检索数据及其索引
     * 2. 快指针指向重复数据时, 记录此时最大长度, 慢指针更新到与快指针重复的数据的下一个位置
     * 优化思路:
     * 使用HashMap优化查找和更新操作, 并优化处理重复字符的逻辑
     * <p>
     * 潜在问题与风险提醒
     * 异常处理与输入验证：
     * 你的代码已经对null和空字符串进行了处理，这是一个很好的实践。但是，对于公共API，建议添加更多的输入验证，以确保方法的健壮性。例如，可以考虑是否需要处理包含非ASCII字符的情况。
     * 性能问题：
     * 在if (set.contains(fastChar))这个条件判断中，HashSet的查找时间复杂度虽然平均是O(1)，但在最坏情况下可能是O(n)，这会影响整体性能。在字符串非常长时，可能会出现性能瓶颈。
     * 循环中使用set.remove(s.charAt(j))移除字符，这个操作的时间复杂度是O(n)，这会进一步降低性能。
     * 逻辑问题：
     * 当检测到重复字符时，你的代码通过更新slow指针来丢弃掉慢指针已经掠过的数据。但是，这个逻辑在有连续重复字符的情况下可能不正确。例如，对于字符串"abcaaa"，当发现第二个'a'时，应该跳过所有的连续'a'，而不仅仅是第一个。
     * 优化方向
     * 改进数据结构：
     * 考虑使用HashMap<Character, Integer>来存储字符及其最近一次出现的索引。这样，你可以在O(1)时间内检查到是否出现过重复，并且可以直接更新slow指针到正确的下一个位置，而不需要逐个移除字符。
     * 避免不必要的数据移除：
     * 优化当前的循环逻辑，以避免在检测到重复字符时从集合中移除字符。相反，应该直接更新slow指针，跳过所有重复的字符。
     * 代码简化：
     * 当字符串长度为1时，可以直接返回1，而不需要进行进一步的判断或处理。这可以使代码更加简洁。
     * 边界条件处理：
     * 对于输入字符串的处理，目前的实现已经相对完善。但是，总是值得记住检查边界条件，如极端的长字符串或包含特殊字符的情况，以确保代码的鲁棒性。
     * 性能测试：
     * 考虑对各种长度和类型的字符串进行性能测试，以验证优化措施的有效性，并识别任何进一步的性能瓶颈。
     * 以下是相应的代码修订与优化。请注意，由于涉及的修改较为复杂，一些细节可能需要进一步调整。
     * 根据提出的建议，下面是优化后的代码。这个版本使用HashMap来存储字符及其索引，以优化查找和更新操作，并简化了逻辑处理重复字符的情况。
     * <p>
     * 实现的优化和调整
     * 使用HashMap<Character, Integer>代替HashSet<Character>：
     * 这样做不仅让我们能够存储字符的索引，以便在检测到重复字符时能够直接更新slow指针，而且还可以在常数时间内完成查找和更新操作。
     * 简化了处理重复字符的逻辑：
     * 当发现重复字符时，通过查询HashMap得到该字符的最新索引，然后更新slow指针。这样可以跳过所有重复的字符，而不需要逐个从集合中移除。
     * 代码优化和简化：
     * 移除了先前版本中不必要的逻辑和循环，使代码更加简洁和高效。
     * 通过这些优化，代码现在应该在处理大型输入时表现得更好，并且更易于理解和维护。此优化后的代码版本仅供参考。
     */
    public static int lengthOfLongestSubstring02(String s) {
        // 检查输入
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        // 使用HashMap来存储字符及其索引
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;
        int fast = 0;

        while (fast < s.length()) {
            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                // 如果字符已存在, 更新slow指针到重复字符的下一个位置
                slow = Math.max(slow, map.get(fastChar) + 1);
            }
            // 更新或添加字符的索引
            map.put(fastChar, fast);
            // 更新最大长度
            max = Math.max(max, fast - slow + 1);
            fast++; // 快指针向后移动
        }

        return max;
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
