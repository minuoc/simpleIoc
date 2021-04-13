package com.simpleioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public interface Resource {
    /**
     * 获取输入流
     * @return
     */
    InputStream getInputStream() throws IOException;
}
