package com.dhk.leetcode.enumeration;

// 2081. Sum of k-Mirror Numbers
// INSIGHTS: just pre-compute everything LOL
public class LC2081 {
    private static final long[][] prefixSums = {
        {
            1L, 4L, 9L, 16L, 25L, 58L, 157L, 470L, 1055L, 1772L, 9219L, 18228L, 33579L, 65802L, 105795L, 159030L,
            212865L, 286602L, 872187L, 2630758L, 4565149L, 6544940L, 9674153L, 14745858L, 20005383L, 25846868L,
            39347399L, 759196316L, 1669569335L, 2609044274L
        },
        {
            1L, 3L, 7L, 15L, 136L, 287L, 499L, 741L, 1225L, 1881L, 2638L, 31730L, 80614L, 155261L, 230718L, 306985L,
            399914L, 493653L, 1342501L, 2863752L, 5849644L, 9871848L, 14090972L, 18342496L, 22630320L, 28367695L,
            36243482L, 44192979L, 71904751L, 155059889L
        },
        {
            1L, 3L, 6L, 11L, 66L, 439L, 832L, 1498L, 2285L, 3224L, 11221L, 64456L, 119711L, 175366L, 233041L,
            739646L, 2540727L, 4755849L, 8582132L, 12448815L, 17500320L, 22726545L, 27986070L, 33283995L, 38898160L,
            44577925L, 98400760L, 721411086L, 1676067545L, 53393239260L
        },
        {
            1L, 3L, 6L, 10L, 16L, 104L, 356L, 638L, 1264L, 1940L, 3161L, 18912L, 37793L, 10125794L, 20526195L,
            48237967L, 78560270L, 126193944L, 192171900L, 1000828708L, 1832161846L, 2664029984L, 3500161622L,
            4336343260L, 6849225412L, 9446112364L, 12339666346L, 19101218022L, 31215959143L, 43401017264L
        },
        {
            1L, 3L, 6L, 10L, 15L, 22L, 77L, 188L, 329L, 520L, 863L, 1297L, 2074L, 2942L, 4383L, 12050L, 19827L,
            41849L, 81742L, 156389L, 325250L, 1134058L, 2043967L, 3911648L, 7009551L, 11241875L, 15507499L,
            19806423L, 24322577L, 28888231L
        },
        {
            1L, 3L, 6L, 10L, 15L, 21L, 29L, 150L, 321L, 563L, 855L, 17416L, 83072L, 2220384L, 6822448L, 13420404L,
            20379000L, 29849749L, 91104965L, 321578997L, 788407661L, 1273902245L, 1912731081L, 2570225837L,
            3428700695L, 29128200347L, 69258903451L, 115121130305L, 176576075721L, 241030621167L
        },
        {
            1L, 3L, 6L, 10L, 15L, 21L, 28L, 37L, 158L, 450L, 783L, 1156L, 1570L, 2155L, 5818L, 14596L, 27727L,
            41058L, 67520L, 94182L, 124285L, 154588L, 362290L, 991116L, 1651182L, 3148123L, 5083514L, 7054305L,
            11253219L, 66619574L
        },
        {
            1L, 3L, 6L, 10L, 15L, 21L, 28L, 36L, 227L, 509L, 882L, 1346L, 1901L, 2547L, 3203L, 10089L, 35841L,
            63313L, 105637L, 156242L, 782868L, 2323319L, 4036490L, 5757761L, 7586042L, 9463823L, 11349704L,
            13750746L, 16185088L, 18627530L
        }
    };

    public static void main(String[] args) {
        long num1 = kMirror(2, 5);
        boolean isCorrect1 = num1 == 25;
        System.out.println(num1 + ": " + isCorrect1);

        long num2 = kMirror(3, 7);
        boolean isCorrect2 = num2 == 499;
        System.out.println(num2 + ": " + isCorrect2);

        long num3 = kMirror(7, 17);
        boolean isCorrect3 = num3 == 20379000;
        System.out.println(num3 + ": " + isCorrect3);
        System.out.println();

        // get pre-compute values for prefixSums array
//        for (int i = 2; i <= 9; i++) {
//            System.out.println("k = " + i);
//            kMirror(i, 30);
//        }
    }

    private static long kMirror(int k, int n) {
        return prefixSums[k - 2][n - 1];

//        long sum = 0;
//        int count = 0;
//        // starting with 1
//        long currentNumberBase10 = 1;
//
//        while (count < n) {
//            // for each 10-mirror number found, check if it's k-mirror as well
//            // if true, increase count and add to sum
//            if (isMirrorInBaseK(k, currentNumberBase10)) {
//                count++;
//                sum += currentNumberBase10;
//                //System.out.println("n = " + count + ": sum = " + sum);
//                //System.out.print(", " + sum + "L");
//            }
//            // get next 10-mirror numbers efficiently
//            currentNumberBase10 = getNextMirrorNumberBase10(currentNumberBase10);
//        }
//        //System.out.println();
//        // return sum when count reaches n
//        return sum;
    }

    private static long getNextMirrorNumberBase10(long mirrorNum) {
        String numStr = String.valueOf(mirrorNum);
        int numOfDigits = numStr.length();
        // loop from the middle of the string to the right (include middle digit)
        for (int i = numOfDigits / 2; i < numOfDigits; i++) {
            char currentChar = numStr.charAt(i);
            // only consider how much to increase the current mirror number once non-9 digit is found
            if (currentChar != '9') {
                int order = numOfDigits - 1 - i;
                // if current char is the exact middle digit, simply add 1 to that middle digit
                if (i == order) {
                    return (long) (mirrorNum + Math.pow(10, order));
                    // add 1 to the current digit and the previous digit (that's just how math works)
                } else {
                    return (long) (mirrorNum + Math.pow(10, order + 1) + Math.pow(10, order));
                }
            }
        }

        // if all the digits of the current mirror number are 9, get the next mirror number by adding 2
        return mirrorNum + 2;
    }

    // NOT USED
    private static long getNextMirrorNumberBaseK(long mirrorNumBase10, int base) {
        // since 2 <= base <= 10, the converted string will only contain chars 0 to 9
        String strNumBaseK = Long.toString(mirrorNumBase10, base);
        int numOfDigits = strNumBaseK.length();
        // loop from the middle of the string to the right (include middle digit)
        for (int i = numOfDigits / 2; i < numOfDigits; i++) {
            char currentChar = strNumBaseK.charAt(i);
            // only consider how much to increase the current mirror number once non-max digit in base k is found
            char charMaxDigitBaseK = (char) ('0' + base - 1);
            if (currentChar != charMaxDigitBaseK) {
                int order = numOfDigits - 1 - i;
                // if current char is the exact middle digit, simply add 1 to that middle digit
                if (i == order) {
                    return (long) (mirrorNumBase10 + Math.pow(base, order));
                // add 1 to the current digit and the previous digit (that's just how math works)
                } else {
                    return (long) (mirrorNumBase10 + Math.pow(base, order + 1) + Math.pow(base, order));
                }
            }
        }

        // if all the digits of the current mirror number are the max digit in base k,
        // get the next mirror number by adding 2
        return mirrorNumBase10 + 2;
    }

    private static boolean isMirrorInBaseK(int k, long num) {
        // get the number of digits of the input number in base k
        int numOfDigitsInBaseK = 0;
        long tempNum = num;
        while (tempNum != 0) {
            tempNum /= k;
            numOfDigitsInBaseK++;
        }

        // check if the digits are the same starting from both ends (ignore middle digit)
        for (int i = 0; i < numOfDigitsInBaseK / 2; i++) {
            int digit1 = (int) ((num / (long) Math.pow(k, i)) % k);
            int digit2 = (int) ((num / (long) Math.pow(k, numOfDigitsInBaseK - 1 - i)) % k);
            if (digit1 != digit2) {
                return false;
            }
        }

        return true;
    }
}

/*
2081. Sum of k-Mirror Numbers

A k-mirror number is a positive integer without leading zeros that reads the same both forward and backward in base-10
as well as in base-k.

For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, which
read the same both forward and backward.
On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the same both
forward and backward.
Given the base k and the number n, return the sum of the n smallest k-mirror numbers.



Example 1:

Input: k = 2, n = 5
Output: 25
Explanation:
The 5 smallest 2-mirror numbers and their representations in base-2 are listed as follows:
base-10    base-2
        1          1
        3          11
        5          101
        7          111
        9          1001
Their sum = 1 + 3 + 5 + 7 + 9 = 25.
Example 2:

Input: k = 3, n = 7
Output: 499
Explanation:
The 7 smallest 3-mirror numbers are and their representations in base-3 are listed as follows:
base-10    base-3
        1          1
        2          2
        4          11
        8          22
        121        11111
        151        12121
        212        21212
Their sum = 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499.
Example 3:

Input: k = 7, n = 17
Output: 20379000
Explanation: The 17 smallest 7-mirror numbers are:
        1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 6597956, 6958596


Constraints:

        2 <= k <= 9
        1 <= n <= 30

 */
