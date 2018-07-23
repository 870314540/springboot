package com.example.demo.es;

import org.aopalliance.intercept.Joinpoint;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/17
 */
@Service
public class ESService {
    private static final Logger logger = LoggerFactory.getLogger(ESService.class);

    @Autowired
    ElasticsearchConfiguration elasticsearchConfiguration;

    //获取一个固定的结果
    public String getResult() {
        GetRequest request = new GetRequest("movies", "movie", "5");
        return esResult(request);
    }

    //传入参数获取结果
    public String getResult(String index, String type, String id) {
        logger.info("index:" + index + ",type:" + type + ",id:" + id);
        GetRequest request = new GetRequest(index, type, id);
        return esResult(request);
    }

    //获取某个索引下的全部结果
    public String getResult(String index) {
        logger.info("index:" + index);
        GetRequest request = new GetRequest(index);
//        GetRequest requestAll = new GetRequest(); 获取全部的es数据
        return esResult(request);
    }

    //请求
    private String esResult(GetRequest request) {
        try {
            GetResponse response = elasticsearchConfiguration.getObject().get(request);
            System.out.println(response);
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
