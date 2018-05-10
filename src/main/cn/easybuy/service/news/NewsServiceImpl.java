package cn.easybuy.service.news;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.utils.Pager;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public int AddNews(News news) {
        return newsDao.AddNews(news);
    }

    @Override
    public int DeleteNews(News news) {
        return newsDao.DeleteNews(news);
    }

    @Override
    public int UpdateNews(News news) {
        // TODO Auto-generated method stub
        return newsDao.UpdateNews(news);
    }

    @Override
    public List<News> findAll() {
        // TODO Auto-generated method stub
        return newsDao.findAll();
    }

    @Override
    public List<News> findTop5() {
        // TODO Auto-generated method stub
        return newsDao.findTop5();
    }

    @Override
    public List<News> queryNewsList(News n, Pager pager) {
        return newsDao.queryNewsList(n, pager);
    }

    /**
     * 返回新闻记录数
     *
     * @return
     */
    @Override
    public int queryNewsCount() {
        return newsDao.queryNewsCount();
    }
}
