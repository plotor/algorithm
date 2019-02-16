package org.zhenchao.algorithm.util;

/**
 * @author zhenchao.wang 2017-04-25 21:32
 * @version 1.0.0
 */
public class ArrayUtils {

    public static void display(boolean[][] array) {
        for (final boolean[] booleans : array) {
            for (final boolean aBoolean : booleans) {
                System.out.print((aBoolean ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }
}
