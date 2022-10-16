class Solution {
    private List<Integer> powers;
    private final int mod = 1000000007;
        
    List<Integer> generatePowersArray(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int rem = (int)(Math.log(n)/Math.log(2));
            list.add((int)Math.pow(2,rem));
            n -= Math.pow(2,rem);
        }
        Collections.reverse(list);
        return list;
    }
    
    int computeAnswers(int[] range) {
        long answer = 1;
        for(int i = range[0]; i <= range[1]; i++) {
            answer = (answer * powers.get(i)) % mod;
        }
        return (int) Math.ceil(answer % mod);
    }
    
    public int[] productQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        this.powers = generatePowersArray(n);
        int i = 0;
        while( i < queries.length) {
            res[i] = computeAnswers(queries[i++]);
        }
        return res;
    }
}