package com.ocean.common;

import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 参数校验
 *
 * @author qianli
 * @version 2018/3/22 15:47
 */
public class ParamCheckUtil {

    /**
     * 参数判断是否为null
     *
     * @param param
     * @throws ServiceException
     */
    public static void nullCheck(Object param) throws ServiceException {
        if (param == null) {
            throw new ServiceException(ErrorCodeEnum.P01);
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param param
     * @throws ServiceException
     */
    public static void emptyCheck(String param) throws ServiceException {
        if (param == null || param.isEmpty()) {
            throw new ServiceException(ErrorCodeEnum.P01);
        }
    }

    /**
     * 小于零的判断
     *
     * @param param
     * @throws
     */
    public static void lessZero(Object param) throws ServiceException {

        if (param instanceof Integer) {
            if ((Integer) param < 0) {
                throw new ServiceException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Long) {
            if ((Long) param < 0) {
                throw new ServiceException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Double) {
            if ((Double) param < 0) {
                throw new ServiceException(ErrorCodeEnum.P01);
            }
        } else if (param instanceof Float) {
            if ((Float) param < 0) {
                throw new ServiceException(ErrorCodeEnum.P01);
            }
        } else {
            throw new ServiceException(ErrorCodeEnum.P01);
        }

    }

    /**
     * 判断List是否为空
     *
     * @param <E>
     */
    public static <E> void emptyListCheck(List<E> list) throws ServiceException {
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ErrorCodeEnum.P01);
        }
    }
}
