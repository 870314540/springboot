package com.example.demo.es;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
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
    @Autowired
    ElasticsearchConfiguration elasticsearchConfiguration;

    public String getResult() {
        GetRequest request = new GetRequest("movies", "movie", "5");
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
