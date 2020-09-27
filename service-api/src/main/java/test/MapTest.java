package test;
import java.util.Objects;

public class MapTest {
    public static void main(String[] args) {
        System.out.println(transform("nice  to meet you!"));
        System.out.println(maxSubString("123456789ABC1"));
    }

    // 单词反转
    private static String transform(String str) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderLetter = new StringBuilder();
        String result = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ') {
                builder.append(str.charAt(i));
            } else {
                result = " " + builder.toString() + result;
                builder.delete(0, builder.length());
            }
        }
        // 尾部处理！！！
        result = " " + builder.toString() + result;
        return result;
    }

    /*
        最长不重复字串：
     */
    private static String maxSubString(String string) {
        if (Objects.isNull(string) || string.length() == 0) {
            return "";
        }
        int[] idxRecord = new int[256];
        for (int i = 0; i < idxRecord.length; ++i) {
            idxRecord[i] = -1;
        }
        int headIdx = 0;
        int maxLen = 0;
        int maxHeadIdx = 0;
        for (int i = 0; i < string.length(); ++i) {
            int idx = string.charAt(i) - '\0';
            if (idxRecord[idx] >= headIdx || (i == string.length() - 1 && idxRecord[idx] < headIdx)) {
                if (i == string.length() - 1 && idxRecord[idx] < headIdx) {
                    // 尾部处理：处理时，必须保证尾部不重复，如果重复，则按照正常的情况处理，否则 i++
                    i++;
                }
                // 冲突：截断
                if (maxLen < i - headIdx) {
                    maxLen = i - headIdx;
                    maxHeadIdx = headIdx;
                }
                System.out.println(headIdx + " " + i + " " + maxLen);
                headIdx = idxRecord[idx] + 1;
            }
            idxRecord[idx] = i;
        }
        return string.substring(maxHeadIdx, maxHeadIdx + maxLen);
    }
}
