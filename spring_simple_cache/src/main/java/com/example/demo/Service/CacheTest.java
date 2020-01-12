package com.example.demo.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheTest {
    static Map<String,String> db = new HashMap<>();
    static {
        for (int i=0 ;i<2;i++){
            db.put("id"+i,"value"+i);
        }
    }
    @Cacheable(value = "cache_test")
    public String getCacheTest(String id)
    {
        System.out.println("no cache");
        for (int i=0 ;i<2;i++){
            System.out.println("wait");
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(db.get(id));
        return db.get(id);
    }

}
