package com.ocean.common;

/**
 * 控制层执行抽象类
 *
 * @author guodahai
 * @version 2018/4/17 上午11:08
 */
public abstract class AbstractControllerExecutor<R> {

    /**
     * 参数校验
     *
     * @throws ServiceException
     */
    public abstract void checkParam() throws ServiceException;

    /**
     * 业务执行
     *
     * @return
     * @throws ServiceException
     */
    public abstract R executeService() throws ServiceException;

    public ResponseResult<R> execute(Object... param) throws ServiceException {
        ResponseResult<R> result = new ResponseResult<R>();
        try {
            checkParam();
            R r = executeService();
            if (r instanceof Boolean) {
                Boolean b = (Boolean) r;
                result.setSuccess(b);
            } else {
                result.setData(r);
            }
        } catch (ServiceException e) {
            result.setSuccess(false);
            result.setErrorCode(e.getErrorCode().getCode());
            result.setErrorMessage(e.getErrorMsg());
        }
        return result;
    }
}
