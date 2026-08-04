class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);

        int k = p.length();

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);

            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);

            if (sortedP.equals(new String(subArr))) {
                ans.add(i);
            }
        }

        return ans;
    }
}