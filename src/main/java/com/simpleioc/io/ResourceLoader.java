package com.simpleioc.io;

import java.net.URL;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class ResourceLoader {

   public ResourceUrl getResource(String location){
       URL url = this.getClass().getClassLoader().getResource(location);
       return new ResourceUrl(url);
   }

}
