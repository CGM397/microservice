package nju.cgm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/27 11:22
 * @description: MyCast
 */
@SuppressWarnings("unchecked")
public class MyCast<T> {

    private Logger logger = LoggerFactory.getLogger(MyCast.class);

    public T castToOne(Object object) {
        T res = null;
        try {
            res = (T) object;
        } catch (ClassCastException e) {
            logger.error(e.getMessage());
        }
        return res;
    }

    public List<T> castToList(Object object) {
        List<T> res = null;
        try {
            res = (List<T>) object;
        } catch (ClassCastException e) {
            logger.error(e.getMessage());
        }
        return res;
    }
}
