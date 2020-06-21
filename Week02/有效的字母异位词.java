
//采用字符数组，排序后比较
public boolean isAnagram(String s, String t) {
    if (s == null && t == null) {
        return true;
    }
    if (s.length() == 0 && t.length() == 0) {
        return true;
    }
    if (s.length() != t.length()) {
        return false;
    }
    char[] ca = s.toCharArray();
    Arrays.sort(ca);

    char[] cb = t.toCharArray();
    Arrays.sort(cb);

    return Arrays.equals(ca, cb);
}

//采用hashMap，遍历s的每个字符，放入map，并记录字符出现的次数；
//遍历t的每个字符，若在map中出现一次，将map中对应字符的个数减一，若减为0，则remove这个key，最后返回map是否为空
public boolean isAnagram(String str, String target) {
    if (str == null && target == null) {
        return true;
    }
    if (str.length() == 0 && target.length() == 0) {
        return true;
    }
    if (str.length() != target.length()) {
        return false;
    }
    Map<String, Integer> map = new HashMap<>();
    char[] strChars = str.toCharArray();
    for (char c :strChars){
        Integer count = map.get(String.valueOf(c));
        if (count != null) {
            count ++;
        } else {
            count = 1;
        }
        map.put(String.valueOf(c), count);
    }

    char[] targetChars = target.toCharArray();
    for (char c : targetChars) {
        Integer count = map.get(String.valueOf(c));
        if ( count == null) {
            return false;
        } else {
            count --;
            if (count == 0) {
                map.remove(String.valueOf(c));
            } else {
                map.put(String.valueOf(c), count);
            }
        }
    }
    return map.isEmpty();
}