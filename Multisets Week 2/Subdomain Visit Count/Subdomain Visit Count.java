class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
       List<String> res = new ArrayList();
        Map<String, Integer> counts = new HashMap();
        
        for (String cpdomain : cpdomains) {
            String[] countDomain = cpdomain.split(" ");
            int count = Integer.parseInt(countDomain[0]);
            String domain = countDomain[1];
            
            counts.put(domain, counts.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    counts.put(subdomain, counts.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}