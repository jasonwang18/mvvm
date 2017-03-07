package com.android.jason.baiduweather.common.constant;

/**
 * Created by wangshizhan on 16/10/22.
 */
public interface HttpConstants {

    interface Timeout {
        int DEFAULT_CONNECT = 15;
        int DEFAULT_READ = 35;
        int DEFAULT_WRITE = 35;

        int DOWNLOAD_CONNECT = 15;
        int DOWNLOAD_READ = 180;
        int DOWNLOAD_WRITE = 35;

        int UPLOAD_CONNECT = 15;
        int UPLOAD_READ = 35;
        int UPLOAD_WRITE = 180;
    }

    interface Method {
        String GET = "GHT";
        String POST = "POST";
        String DOWNLOAD = "DOWNLOAD";
        String UPLOAD = "UPLOAD";
    }

    int DEFAULT_REQUEST = 0;

    int FIRST_REQUEST = 100001;

}
