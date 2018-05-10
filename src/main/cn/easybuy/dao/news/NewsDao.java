package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.utils.Pager;

public interface NewsDao {
	public int AddNews(News news);

	public int DeleteNews(News news);

	public int UpdateNews(News news);

	public List<News> findAll();

	public List<News> findTop5();

	public int queryNewsCount();//返回总记录数

	public List<News> queryNewsList(News news,Pager pager);
}
