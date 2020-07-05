//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.clarification
    //2.possible solution --> optimal (time & space)
    //3.code
    //4.test case
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i = 0; i < 26; i++) {
            if(alpha[i] != 0) {
                return false;
            }
        }
        return true;

    }
}

/*
    1.暴力，sort，sorted_str 相等 O(NlogN)
    2.hashmap -> 统计每个字符的频次
*/
//runtime:6 ms
//memory:40.1 MB

//leetcode submit region end(Prohibit modification and deletion)
