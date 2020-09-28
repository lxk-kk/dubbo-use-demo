package test;


class Solution {
    private int[] rone;
    private int[] rtwo;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkInclusion("ky", "ainwkckifykxlribaypk");
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        rone = new int[26];
        rtwo = new int[26];

        for(int i = 0; i < s1.length(); ++i){
            rone[s1.charAt(i) - 'a']++;
            rtwo[s2.charAt(i) - 'a']++;
        }

        boolean go = true;
        // 多余的
        int illegal = 0;
        // 缺失的
        int legal = 0;
        for(int i = 0; i < 26; ++i){
            if(rone[i] > 0 && rtwo[i] == 0){
                legal++;
            } else if(rone[i] == 0 && rtwo[i] > 0){
                illegal++;
            }
            go = go && (rone[i] == rtwo[i]);
        }

        int pre = 0;
        int end = s1.length();
        for(; !go && end < s2.length(); ++pre, ++end){
            int preIdx = s2.charAt(pre) - 'a';
            int nowIdx = s2.charAt(end) - 'a';

            rtwo[preIdx]--;
            if(rtwo[preIdx] == 0){ // 有 -> 无
                if(rone[preIdx] == 0){ // 不是目标
                    illegal--;
                } else { // 是目标
                    legal++;
                }

            }

            rtwo[nowIdx]++;
            if(rtwo[nowIdx] == 1){ // 无 -> 有
                if(rone[nowIdx] > 0){ // 是目标
                    legal--;
                } else { // 不是目标
                    illegal++;
                }
            }
            if(rtwo[preIdx] != rone[preIdx] || rone[nowIdx] != rtwo[nowIdx]){
                continue;
            }
            if(illegal == 0 && legal == 0){
                continue;
            }
            if (preIdx == nowIdx) {
                continue;
            }
            go = judge();
        }
        return go;
    }
    private boolean judge(){
        for(int i = 0; i < 26; ++i){
            if(rone[i] == rtwo[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}