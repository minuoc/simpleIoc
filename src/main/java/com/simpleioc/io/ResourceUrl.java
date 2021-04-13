package com.simpleioc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class ResourceUrl implements Resource{

    private final URL url;

    public ResourceUrl(URL url) {
        this.url = url;
    }

    /**
     * 从url 中获取输入流
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }

}
