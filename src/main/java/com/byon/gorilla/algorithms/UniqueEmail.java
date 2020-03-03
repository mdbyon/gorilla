package com.byon.gorilla.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmail {

    public static int numUniqueEmails(String[] emails) {

        Map<String, Set<String>> map = new HashMap();

        for (int i = 0; i < emails.length; i++) {
            String[] address = emails[i].split("@");
            if (!map.containsKey(address[1])) {
                Set<String> initial = new HashSet();
                StringBuilder sbInitial = new StringBuilder();
                for (int j = 0; j < address[0].length(); j++) {
                    if (emails[i].charAt(j) == '+') break;
                    if (emails[i].charAt(j) == '.') continue;
                    sbInitial.append(emails[i].charAt(j));
                }
                initial.add(sbInitial.toString());
                map.put(address[1], initial);
            } else {
                Set<String> curr = map.get(address[1]);
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < address[0].length(); k++) {
                    if (emails[i].charAt(k) == '+') break;
                    if (emails[i].charAt(k) == '.') continue;
                    sb.append(emails[i].charAt(k));
                }
                curr.add(sb.toString());
                map.put(address[1], curr);
            }
        }

        int result = 0;
        for (String key : map.keySet()) {
            result += map.get(key).size();
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
    }
}
