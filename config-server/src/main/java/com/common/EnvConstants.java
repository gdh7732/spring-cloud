package com.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author guodahai
 * @version 2018/9/4 17:58
 */
public final class EnvConstants {

    /**
     * 生产环境
     */
    public static final String PROD = "prod";

    /**
     * 线上测试环境
     */
    public static final String ONLINE = "online";

    /**
     * 本地开发环境
     */
    public static final String DEV = "dev";

    /**
     * 线下测试环境
     */
    public static final String TEST = "test";

    public static List<String> ENVS = Arrays.asList(PROD, ONLINE, DEV, TEST);
}
