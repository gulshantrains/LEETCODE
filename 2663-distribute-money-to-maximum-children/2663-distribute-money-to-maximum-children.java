class Solution {
    public int distMoney(int money, int children) {
        if (money < children)
            return -1;

        int cnt = 0;
        money -= children;

        while (money >= 7 && children > 0) {
            money -= 7;
            children--;
            cnt++;
        }
        if (cnt == 0)
            return cnt;
        else {
            if (money > 0 && children == 0)
                cnt -= 1;
            if (money == 3 && children == 1)
                cnt -= 1;
        }
        return cnt;

    }
}