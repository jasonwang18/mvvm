package com.android.jason.baiduweather.common.constant;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshizhan on 16/10/22.
 */
public class HttpError extends RuntimeException {

    /**
     * 登录超时
     */
    public static final int ERR_CODE_LOGING_TIMEOUT = -2;

    /**
     * 未知错误类型*
     */
    public static final int ERR_CODE_UNKNOWN = -1;

    /**
     * 网络错误*
     */
    public static final int ERR_CODE_NETWORK_CODE = 1001;

    /**
     * 服务器异常*
     */
    public static final int ERR_CODE_SERVER_ERROR = 1002;

    /**
     * 连接超时
     */
    public static final int ERR_CODE_CONNECT_TIMEOUT = 1003;

    /**
     * SOCKET 超时
     */
    public static final int ERR_CODE_SOCKET_TIMEOUT = 1004;

    /**
     * 数据解析异常错误
     */
    public static final int ERR_CODE_PARSE_DATA_ERROR = 7001;

    /**
     * 链接被取消
     */
    public static final int ERR_CODE_DATA_EMPTY = 9001;
    /**
     * 链接被取消
     */
    public static final int ERR_CODE_CANCELED = 9002;

    /**
     * 操作失败
     */
    public static final int ERR_CODE_FAILED = 9003;


    private int code = ERR_CODE_UNKNOWN;
    private String title;
    private Gson info = new Gson();

    public static Map<Integer, String> HTTP_ERROR_MAP = new HashMap<>();

    static {
        HTTP_ERROR_MAP.put(ERR_CODE_LOGING_TIMEOUT, "登录失效，请重新登录");
        HTTP_ERROR_MAP.put(ERR_CODE_SERVER_ERROR, "服务器异常");
        HTTP_ERROR_MAP.put(ERR_CODE_CONNECT_TIMEOUT, "连接超时");
        HTTP_ERROR_MAP.put(ERR_CODE_SOCKET_TIMEOUT, "连接超时");
        HTTP_ERROR_MAP.put(ERR_CODE_NETWORK_CODE, "网络错误");
        HTTP_ERROR_MAP.put(ERR_CODE_UNKNOWN, "未知错误");
    }

    public HttpError(int code) {
        this.code = code;
    }

    public HttpError(int code, String message) {
        super(message);
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Gson getInfo() {
        return info;
    }

    public void setInfo(Gson info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String errorString;
        switch (code) {
            case ERR_CODE_NETWORK_CODE: {
                errorString = "网络错误";
                break;
            }
            case ERR_CODE_SERVER_ERROR: {
                errorString = getMessage();
                break;
            }
            default: {
                errorString = getMessage();
                break;
            }
        }
        return errorString;
    }

    @Override
    public String getMessage() {
        String errorMessage = HTTP_ERROR_MAP.get(code);
        if (TextUtils.isEmpty(errorMessage) && !TextUtils.isEmpty(super.getMessage())) {
            return super.getMessage();
        }
        return errorMessage;
    }

}
