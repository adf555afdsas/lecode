package algorithms.String;

import java.util.HashMap;

public class MinWindow {
    public static String doing(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char letter = str2.charAt(i);
            map.put(letter,map.getOrDefault(letter, 0)+1);
        }

        int start = 0;
        int end = 0;
        int count = map.size();
        int minlenth = Integer.MAX_VALUE;
        int minstart = start;
        int minend = end;
        while (end < str1.length() || (count==0 && end == str1.length())) {
            if(count>0){
                char endchar = str1.charAt(end);
                if(map.containsKey(endchar)){
                    map.put(endchar,map.get(endchar)-1);
                    if(map.get(endchar)==0)count--;

                }
                end ++;

            }else {
                if ((end - start) < minlenth){
                    minlenth = end - start;
                    minstart = start;
                    minend = end;
                }
                char tmp_key = str1.charAt(start);
                if(map.containsKey(tmp_key)){
                    map.put(tmp_key, map.get(tmp_key)+1);
                    if(map.get(tmp_key)==1)count++;
                }
                start++;

            }

        }

        return  minlenth < Integer.MAX_VALUE? str1.substring(minstart, minend):"";

    }

    public static void main(String[] args) {
//        System.out.println(doing("ADDBANCAD", "ABC"));
        System.out.println("ADDBANCAD".substring(0,1));
    }
}
