class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
              Map<String, Integer> map = new HashMap();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }
}
