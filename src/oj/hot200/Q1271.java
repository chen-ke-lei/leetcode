package oj.hot200;

public class Q1271 {
    public String toHexspeak(String num) {
        String res = "";
        while (!num.equals("0")) {
            int i = 0;
            StringBuilder tmp = new StringBuilder();
            String last = "";
            while (i < num.length()) {
                int step = Math.min(i + 7, num.length());
                String subString = last + num.substring(i, step);
                String sub = Integer.valueOf(subString) / 16 + "";
                while (tmp.length() > 0 && last.length() == 1 && sub.length() + 1 < subString.length()) sub = "0" + sub;
                tmp.append(sub);
                last = Integer.valueOf(subString) % 16 + "";
                i += step;

            }
            int sub = new Integer(last);
            if (sub >= 2 && sub <= 9) return "ERROR";
            switch (sub) {
                case 0:
                    res = 'O' + res;
                    break;
                case 1:
                    res = 'I' + res;
                    break;
                case 10:
                    res = 'A' + res;
                    break;
                case 11:
                    res = 'B' + res;
                    break;
                case 12:
                    res = 'C' + res;
                    break;
                case 13:
                    res = 'D' + res;
                    break;
                case 14:
                    res = 'E' + res;
                    break;
                case 15:
                    res = 'F' + res;
                    break;
            }
            num = tmp.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q1271().toHexspeak("747823223228"));
    }

}
