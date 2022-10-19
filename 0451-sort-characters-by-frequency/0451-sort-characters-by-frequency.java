class Pair {
    public char letter;
    public int count;
    
    Pair(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];
        List<Character> letters = Arrays.asList(new Character[s.length()]);
        for(int i = 0 ; i < s.length(); i++) {
            int ascii = s.charAt(i);
            freq[ascii]++;
            letters.set(i, s.charAt(i));
        }
        
        Collections.sort(letters, (a, b) -> freq[b] != freq[a] ? freq[b] - freq[a] : b-a);
        StringBuilder result = new StringBuilder();
        for(char letter: letters) {
          result.append(letter);  
        }
        return result.toString();
    }
}