package com.wenqi.demo01.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenqi Liang
 * @date 8/10/2023
 */
public class IsAnagram242 {
    public static void main(String[] args) {
        IsAnagram242 isAnagram242 = new IsAnagram242();
        isAnagram242.isAnagram2("anagram", "nagaram");
    }

    /**
     * 时间  3ms
     * 击败 79.59%使用 Java 的用户
     * <p>
     * 内存 39.84mb
     * 击败 88.86%使用 Java 的用户
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];

        for (int i = 0; i < t.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            result[t.charAt(i) - 'a']--;
            if (result[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 时间  4ms
     * 击败 40.97%使用 Java 的用户
     * <p>
     * 内存 39.84mb
     * 击败 88.86%使用 Java 的用户
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];

        for (int i = 0; i < t.length(); i++) {
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }

        for (int j : result) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * 时间 17ms
     * 击败 10.95%使用 Java 的用户
     * <p>
     * 内存  41.47mb
     * 击败 21.72%使用 Java 的用户
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (map.containsKey(sc)) {
                Integer count = map.get(sc);
                map.put(sc, count + 1);
            } else {
                map.put(sc, 1);
            }

        }

        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            if (map.containsKey(tc)) {
                Integer count = map.get(tc);
                if (count == 1) {
                    map.remove(tc);
                } else {
                    map.put(tc, count - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
