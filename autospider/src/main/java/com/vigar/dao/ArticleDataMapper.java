package com.vigar.dao;

import com.vigar.model.ArticleData;

public interface ArticleDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleData record);

    int insertSelective(ArticleData record);

    ArticleData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleData record);

    int updateByPrimaryKeyWithBLOBs(ArticleData record);

    int updateByPrimaryKey(ArticleData record);
}