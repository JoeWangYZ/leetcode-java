package contest.weeklycontest172;

import java.util.ArrayList;
import java.util.List;

/**
 *  显示英文描述
 用户通过次数0
 用户尝试次数0
 通过次数0
 提交次数0
 题目难度Medium
 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 每个单词只能放在一列上，每一列中也只能有一个单词。



 示例 1：

 输入：s = "HOW ARE YOU"
 输出：["HAY","ORO","WEU"]
 解释：每个单词都应该竖直打印。
 "HAY"
 "ORO"
 "WEU"
 示例 2：

 输入：s = "TO BE OR NOT TO BE"
 输出：["TBONTB","OEROOE","   T"]
 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 "TBONTB"
 "OEROOE"
 "   T"
 示例 3：

 输入：s = "CONTEST IS COMING"
 输出：["CIC","OSO","N M","T I","E N","S G","T"]


 提示：

 1 <= s.length <= 200
 s 仅含大写英文字母。
 题目数据保证两个单词之间只有一个空格。
 * Created by wangyuzhou on 2020/1/19.
 *
 * STATUS: PASS
 */
public class PrintVertically {
    public List<String> printVertically(String s) {
        List<String> resultList = new ArrayList<String>();
        if (null == s || s.length() == 0) {
            return resultList;
        }
        List<String> words = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                }
                words.add(word.toString());
                word = new StringBuilder();
                continue;
            }
            word.append(cur);
            if (i == s.length() - 1) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                }
                words.add(word.toString());
                word = new StringBuilder();
                continue;
            }
        }
        for (int i = 0; i < maxLength; i ++) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder spaceBuilder = new StringBuilder();
            for (int j = 0; j < words.size(); j ++) {
                String w = words.get(j);
                char cur;

                if (w.length() <= i) {
                    cur = ' ';
                    spaceBuilder.append(cur);
                } else {
                    cur = w.charAt(i);
                    stringBuilder.append(spaceBuilder).append(cur);
                    spaceBuilder = new StringBuilder();
                }
            }
            resultList.add(stringBuilder.toString());
        }

        return resultList;
    }

    public static void main(String[] args) {
        PrintVertically test = new PrintVertically();
        List<String> result = test.printVertically("TO BE OR NOT TO BE");
        for (String s : result) {
            System.out.println("result = " + s);
        }


    }
}
