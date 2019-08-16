package com.es.entity;

import com.es.util.IndexName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * ArticleEntity
 * @date 2019/8/12
 * @author luohaipeng
 */
@Data
@IndexName("articles-1")
public class ArticleEntity {

    private Long id;
    private String title;
    private String content;
}
