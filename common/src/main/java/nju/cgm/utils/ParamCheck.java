package nju.cgm.utils;

/**
 * @author: Bright Chan
 * @date: 2020/8/27 10:39
 * @description: ParamCheck，可变参数可以传入数组，但是不能传入List之类的集合
 */
public class ParamCheck {

    // 传入参数若为List<Object>，则会被看作一个Object，
    // 而传入Object[]，则会被看作Object数组
    public static boolean ObjectIsEmpty(Object... objects) {
        for (Object one : objects) {
            if (one == null || "".equals(one)) return true;
        }
        return false;
    }
}
