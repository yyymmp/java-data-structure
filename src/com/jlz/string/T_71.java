package com.jlz.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author clearlove
 * @ClassName T_71.java
 * @Description
 * @createTime 2021年07月14日 23:44:00
 */
public class T_71 {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(Arrays.toString(path.split("/")));
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        LinkedList<String> res = new LinkedList<>();
        res.add("/");
        String[] split = path.split("/");
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals(".")) {
                continue;
            }
            if (split[i].equals("..")) {
                if (res.size() > 1) {
                    res.removeLast();
                }
            } else if (split[i].equals("")) {
                continue;
            } else {
                res.addLast(split[i] + "/");

            }
        }
        if (res.size() == 0) {
            return "/";
        }
        String string = res.stream().collect(Collectors.joining());

        return string.equals("/")?string:string.substring(0, string.length() - 1);
    }
}
