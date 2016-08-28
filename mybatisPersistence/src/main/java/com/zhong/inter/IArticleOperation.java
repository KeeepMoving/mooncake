package com.zhong.inter;

import java.io.Serializable;
import java.util.List;

import com.zhong.pojo.Article;

public interface IArticleOperation extends ITemplate<Article>{

	List<Article> queryByUserId(Serializable id) throws Exception;
	
}
