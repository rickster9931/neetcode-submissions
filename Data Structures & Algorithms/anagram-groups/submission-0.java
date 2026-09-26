class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] calc = new int[26];
            for (int k = 0; k < strs[i].length(); k++) {
                calc[strs[i].charAt(k) - 'a'] += 1;
            }
            if (!(map.containsKey(Arrays.toString(calc)))) {
                List<String> individual = new ArrayList<>();
                individual.add(strs[i]);
                map.put(Arrays.toString(calc), individual);
            }
            else {
                List<String> individual = map.get(Arrays.toString(calc));
                individual.add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
