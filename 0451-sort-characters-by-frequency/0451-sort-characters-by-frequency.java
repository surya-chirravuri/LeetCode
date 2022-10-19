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
        for(int i = 0 ; i < s.length(); i++) {
            int ascii = s.charAt(i);
            freq[ascii]++;
        }
        
        Queue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.count - a.count);
        
        for(int i = 0; i < 256; i++) {
            if(freq[i] > 0) {
                pq.offer(new Pair( (char) i, freq[i]));
            }
        }
                     
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            for (int i = 0 ; i < top.count; i++) {
                result.append(top.letter);
            }
        }
        
        return result.toString();
    }
}