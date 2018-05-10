package cn.easybuy.service.news;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.utils.Pager;

public interface NewsService {
	public int AddNews(News news);

	public int DeleteNews(News news);

	public int UpdateNews(News news);

	public List<News> findAll();

	public List<News> findTop5();

	public int queryNewsCount();//返回总记录数

	public List<News> queryNewsList(News n, Pager pager);
}
