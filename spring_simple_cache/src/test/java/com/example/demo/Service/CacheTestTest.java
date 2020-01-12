package com.example.demo.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheTestTest {

    @Autowired
    private CacheTest cacheTest;
    @Test
    void getCacheTest() {
        System.out.println("id1===> : "+cacheTest.getCacheTest("id1"));
        System.out.println("id1===> : "+cacheTest.getCacheTest("id1"));
        System.out.println("id1===> : "+cacheTest.getCacheTest("id1"));
    }
}