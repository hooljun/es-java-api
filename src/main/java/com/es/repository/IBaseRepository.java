package com.es.repository;

import com.es.qo.PageResult;
import com.es.qo.QueryObject;
import org.elasticsearch.client.RestClient;

import java.util.List;
/**
 * 封装通用的操作ES方法
 * @date 2019/8/12
 * @author luohaipeng
 * @param <T>
 */
public interface IBaseRepository<T> {

    /**
     * 关闭连接
     */
    void close() throws Exception;

    /**
     * 获取低水平客户端
     * @return RestClient
     */
    RestClient getLowLevelClient();

    /**
     * 新增和修改数据
     * @param t
     * @throws Exception
     */
    void insertOrUpdate(T t) throws Exception;

    /**
     * 通过文档id删除文档
     * @param id
     * @throws Exception
     */
    void delete(Long id) throws Exception;

    /**
     * 通过文档id获取文档
     * @param id
     * @return
     * @throws Exception
     */
    T get(Long id) throws Exception;

    /**
     * 获取所有文档
     * @return
     * @throws Exception
     */
    List<T> getAll() throws Exception;

    /**
     * 搜索
     * @param qo
     * @return
     * @throws Exception
     */
    PageResult<T> search(QueryObject qo) throws Exception;

}
