package oj.newcoder.todo;

import java.util.ArrayList;

// TODO: 2020/2/3  
public class TextJustification {
    public static void main(String[] a) {
        System.out.println(new TextJustification().fullJustify(new String[]{"Here","is","an","example","of","text","justification."}, 16));
    }

    public ArrayList<String> fullJustify(String[] words, int L) {
        if (words == null || words.length == 0)
            return new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>(), res = new ArrayList<>();
        int lineNum = 0;
        for (int i = 0; i < words.length; i++) {
            // System.out.println(lineNum+"   "+words[i]);
            if (words[i].length() == 0)
                continue;
            if (lineNum + words[i].length() + 1 <= L) {
                if (lineNum == 0)
                    lineNum = words[i].length();
                else
                    lineNum = lineNum + words[i].length() + 1;
                tmp.add(words[i]);
            } else {
                insertLine(lineNum, L, tmp, res);
                tmp = new ArrayList<>();
                lineNum = words[i].length();
                tmp.add(words[i]);

            }

        }
        insertLine(lineNum, L, tmp, res);
        if (res.size() == 0) {
            String tmpStr = "";
            for (int i = 0; i < L; i++)
                tmpStr += " ";
            res.add(tmpStr);
        }
        String tmpStr = res.get(res.size() - 1);
        res.remove(res.size() - 1);
        tmpStr = tmpStr.replaceAll("[ ]+", " ");
        if (tmpStr.length() < L) tmpStr += "";
        res.add(tmpStr);
        return res;
    }

    void insertLine(int lineNum, int L, ArrayList<String> tmp, ArrayList<String> res) {
        if (lineNum > 0) {
            int space = L - (lineNum - tmp.size() + 1);
            int averageSpace = 0;
            if (tmp.size() > 1)
                averageSpace = space / (tmp.size() - 1);
            String tmpStr = "";
            for (int j = 0; j < tmp.size() - 1; j++) {
                tmpStr = tmpStr + tmp.get(j);
                L -= tmp.get(j).length();
                for (int k = 0; k < averageSpace; k++) {
                    tmpStr += ' ';
                    L--;
                }
            }
            tmpStr += tmp.get(tmp.size() - 1);
            L -= tmp.get(tmp.size() - 1).length();
            for (int j = 0; j < L; j++)
                tmpStr += " ";
            res.add(tmpStr);
            System.out.println(tmpStr.length());
        }
    }
}
