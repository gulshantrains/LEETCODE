class Solution {
    public int maximum69Number(int num) {
        int placeVal = 0;
        int lastIdx = -1;

        int temp = num;

        while (temp > 0) {
            int rem = temp % 10;

            if (rem == 6)
                lastIdx = placeVal;

            temp /= 10;
            placeVal++;
        }
        if (lastIdx == -1)
            return num;
//If we got last index of 6 then if we replace it with 9 then total inc=+3 ie...3X10^lastIdx
//9669--->9669 + 3*100
        return num + 3 * (int) Math.pow(10, lastIdx);
    }
}
/*
class Solution {
    public int maximum69Number(int num) {
        String n = "" + num;
        n = n.replaceFirst("6", "9");

        return Integer.parseInt(n);
    }
}
*/