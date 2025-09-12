class Solution {
    public boolean doesAliceWin(String s) {
      int vcnt=0;
      for(char x:s.toCharArray()){
        if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') vcnt++;
      }

      if(vcnt==0) return false; //No vowel so Alice cant play move
      //else if(vcnt%2 != 0 || vcnt %2==0) return true; //Vowel count is odd so alice will win in 1 move




      
      return true;
    }
}