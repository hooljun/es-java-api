package com.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchRestClient {

    @Value("${elasticsearch.ip}")
    private String[] ips;

    /**
     * Bean name default  函数名字
     * @return
     */
    //@Bean(autowire = Autowire.BY_NAME, name = "restHighLevelClient")
    @Bean
    public RestHighLevelClient client() {
        HttpHost[] httpHosts = new HttpHost[ips.length];
        for(int i=0;i<ips.length;i++){
            httpHosts[i] = HttpHost.create(ips[i]);
        }
        RestClientBuilder builder = RestClient.builder(httpHosts);
        return new RestHighLevelClient(builder);
    }

}
