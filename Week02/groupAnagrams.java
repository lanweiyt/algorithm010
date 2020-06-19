
public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
        String key = sort(str);
        List<String> strList = map.getOrDefault(key, new ArrayList<>());
        strList.add(str);
        map.put(key, strList);
    }

    map.forEach((key, value) -> {
        res.add(value);
    });

    return res;
}

public String sort(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
}