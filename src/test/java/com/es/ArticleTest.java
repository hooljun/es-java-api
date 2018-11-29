package com.es;

import com.es.qo.ArticleQueryObject;
import com.es.qo.PageResult;
import com.es.repository.IArticleRepository;
import com.es.vo.ArticleVo;
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
        ArticleVo article = new ArticleVo();
        article.setId(2L);
        article.setTitle("这是一篇文档2");
        article.setContent("这是一篇文档这是一篇文档这是一篇文档这是一篇文档2");
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
        ArticleVo article = articleRepository.get(3L);
        System.out.println(article);
    }


    /**
     *测试获取所有文档
     */
    @Test
    public void getAll() throws Exception {
        List<ArticleVo> list = articleRepository.getAll();
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
