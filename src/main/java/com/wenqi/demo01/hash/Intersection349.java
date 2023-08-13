package com.wenqi.demo01.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Wenqi Liang
 * @date 8/13/2023
 */
public class Intersection349 {
    /**
     * 时间 2ms
     * 击败 93.53%使用 Java 的用户
     * <p>
     * 内存 41.61mb
     * 击败 22.56%使用 Java 的用户
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] arr = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            arr[index] = num;
            index++;
        }
        return arr;
    }

    /**
     * 时间 3ms
     * 击败 46.70%使用 Java 的用户
     * <p>
     * 内存 41.66mb
     * 击败 12.71%使用 Java 的用户
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int length = Math.max(nums1.length, nums2.length);
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            Integer n1 = null;
            Integer n2 = null;
            if (i < nums1.length) {
                n1 = nums1[i];
            }

            if (i < nums2.length) {
                n2 = nums2[i];
            }

            if (Objects.nonNull(n1)) {
                Integer i1 = map.get(n1);
                if (Objects.nonNull(i1)) {
                    if (i1 == 2) {
                        set.add(n1);
                    }
                } else {
                    map.put(n1, 1);
                }
            }

            if (Objects.nonNull(n2)) {
                Integer i2 = map.get(n2);
                if (Objects.nonNull(i2)) {
                    if (i2 == 1) {
                        set.add(n2);
                    }
                } else {
                    map.put(n2, 2);
                }
            }
        }
        return set.stream().mapToInt(e -> e).toArray();
    }
}
