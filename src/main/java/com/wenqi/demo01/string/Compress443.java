package com.wenqi.demo01.string;

/**
 * @author Wenqi Liang
 * @date 2022/9/24
 */
public class Compress443 {
    public static void main(String[] args) {
//        String str = "aabbccc";
        String str = "a" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "c";
//        String str = "a" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b" + "b";
        System.out.println(compress(str.toCharArray()));
    }


    public static int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int left = 0;
        int right = 1;
        while (right < chars.length) {
            if (right == chars.length - 1 || chars[left] != chars[right]) {
                int count = right - left;
                if (count > 1) {
                    String sCount = String.valueOf(count);
                    for (int i = 0; i < sCount.length(); i++) {
                        chars[++left] = sCount.charAt(i);
                    }
                    chars[++left] = chars[right];
                } else {
                    left++;
                }
            }
            right++;
        }
        return left;
    }

    public static int compress2(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int left = 0;
        int right = 1;
        int count = 1;
        // todo right的char 应该赋值给left的char
        while (right < chars.length) {
            if (chars[left] != chars[right]) {
                if (count >= 10) {
                    String sCount = String.valueOf(count);
                    int index = 0;
                    while (index < sCount.length()) {
                        chars[++left] = sCount.charAt(index);
                        index++;
                    }
                } else if (count > 1) {
                    chars[++left] = (char) (count + '0');
                } else {
                    right++;
                    continue;
                }
                chars[++left] = chars[right];
                left++;
                count = 0;
            }
            count++;
            right++;
        }

        if (count > 1) {
            String sCount = String.valueOf(count);
            for (int i = 0; i < sCount.length(); i++) {
                chars[left++] = sCount.charAt(i);
            }
        }

        return left;
    }
}
