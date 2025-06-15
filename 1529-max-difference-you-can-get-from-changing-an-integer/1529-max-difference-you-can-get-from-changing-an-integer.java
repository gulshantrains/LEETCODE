class Solution {

    public int maxDiff(int num) {
        String temp1 = num + ""; //Integer converted into string
        int i = 0;

        //Take pointer to place where first digit is not 9
        while (i < temp1.length() && (temp1.charAt(i) == '9')) {
            i++;
        }
        System.out.println("idx: " + i);
        //Make maximum number by replacing it with 9
        if (i < temp1.length()) {
            char x1 = temp1.charAt(i);
            char y1 = '9';

            temp1 = temp1.replace(x1, y1);
        }
        int a = Integer.valueOf(temp1);
        System.out.println("Num a: " + a);

        String temp2 = num + ""; //Integer converted into string
        i = 0;

        if (temp2.charAt(0) != '1') {
            temp2 = temp2.replace(temp2.charAt(0), '1');

        } else {
            while (i < temp2.length() && (temp2.charAt(i) == '0' || temp2.charAt(i) == '1')) {
                i++;
            }
            if (i < temp2.length())
                temp2 = temp2.replace(temp2.charAt(i), '0');
        }

        int b = Integer.valueOf(temp2);
        return a - b;

    }
}