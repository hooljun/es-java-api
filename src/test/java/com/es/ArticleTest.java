package com.es;

import com.es.qo.ArticleQueryObject;
import com.es.qo.PageResult;
import com.es.repository.IArticleRepository;
import com.es.entity.ArticleEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleTest extends ApplicationTest{

    @Autowired
    private IArticleRepository articleRepository;

    /**
     *测试添加文档
     */
    @Test
    public void inster() throws Exception {
        ArticleEntity article = new ArticleEntity();
        article.setId(2L);
        article.setTitle("这是一篇文档222");
        article.setContent("这是一篇文档这是一篇文档这是一篇文档这是一篇文档222");
        articleRepository.insertOrUpdate(article);
    }

    /**
     * 测试删除文档
     */
    @Test
    public void delete() throws Exception {
        articleRepository.delete(3L);
    }

    /**
     * 测试通过id获取文档
     */
    @Test
    public void get() throws Exception {
        ArticleEntity article = articleRepository.get(1L);
        System.out.println(article);
    }


    /**
     *测试获取所有文档
     */
    @Test
    public void getAll() throws Exception {
        List<ArticleEntity> list = articleRepository.getAll();
        list.forEach(articleVo -> {
            System.out.println(articleVo);
        });
    }

    /**
     * 搜索
     */
    @Test
    public void search() throws Exception {
        ArticleQueryObject qo = new ArticleQueryObject();
        qo.setKeyword("2");
        PageResult pageResult = articleRepository.search(qo);
        pageResult.getData().forEach(articleVo -> {
            System.out.println(articleVo);
        });
    }
}
