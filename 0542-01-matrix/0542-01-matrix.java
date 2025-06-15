class Solution {
    // एक Pair क्लास जो row और col को स्टोर करती है
    class P {
        int row, col;

        P(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // 4 दिशाएं: बाएं, दाएं, ऊपर, नीचे
    private int[] dr = new int[] { 0, 0, -1, 1 };
    private int[] dc = new int[] { -1, 1, 0, 0 };

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        Queue<P> qu = new LinkedList<>();

        // सारे 0 वाले सेल्स को queue में डालो और उनका distance 0 set करो
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    qu.offer(new P(i, j)); // 0 वाले cells से BFS शुरू करेंगे
                } else {
                    ans[i][j] = -1; // बाकी सबको फिलहाल -1 से mark कर दो (मतलब अभी तक distance तय नहीं)
                }
            }
        }

        // अब multi-source BFS चालू करो
        while (!qu.isEmpty()) {
            P temp = qu.poll();

            int r = temp.row;
            int c = temp.col;

            // हम ans[r][c] से इसके आस-पास के चारों direction में जाएंगे
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // अगर नया cell grid के अंदर है और उसका distance अभी तक तय नहीं हुआ
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (ans[nr][nc] == -1) {

                        // तो उसका distance, current cell से 1 ज्यादा होगा
                        // क्योंकि हम लोग ans[r][c] से आ रहे हैं, मतलब उसका जितना distance होगा,
                        // उससे बस एक ज़्यादा ही होगा (एक edge दूर)
                        
                        ans[nr][nc] = ans[r][c] + 1;

                        // और उसे भी queue में डाल दो ताकि उससे आगे और cells explore कर सको
                        qu.offer(new P(nr, nc));
                    }
                }
            }
        }

        return ans; // final matrix जिसमें हर cell से सबसे नज़दीकी 0 की दूरी दी है
    }
}
