class Solution {
    public String removeOccurrences(String s, String part) {
        //If s conatins part then replace it with null and continue this till over
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}