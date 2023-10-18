import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> al = new ArrayList<>();
        for (int num : numbers) {
            al.add(String.valueOf(num));
        }
        Collections.sort(al, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // Collections.sort(al, Collections.reverseOrder());
        // System.out.println(al);
        
        if (al.get(0).equals("0")) return "0";
        
        String str = "";
        
        for (String s : al) {
            str += s;
        }
        
        return str;
    }
}