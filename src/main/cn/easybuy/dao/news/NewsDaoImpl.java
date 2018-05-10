package cn.easybuy.dao.news;

import cn.easybuy.entity.News;
import cn.easybuy.utils.BaseDao;
import cn.easybuy.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public int AddNews(News news) {
        String sql = "INSERT INTO easybuy.easybuy_news(id,title,content,createTime)VALUES(?,?,?,?)";
        Object[] param = {news.getId(), news.getTitle(), news.getContent(), news.getCreateTime()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int DeleteNews(News news) {
        String sql = "DELETE FROM easybuy.easybuy_news WHERE id = ?";
        Object[] param = {news.getId()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int UpdateNews(News news) {
        String sql = "UPDATE easybuy.easybuy_news SET title =? , content = ? , createTime = ? WHERE	id = ?";
        Object[] param = {news.getTitle(), news.getContent(), news.getCreateTime(), news.getId()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public List<News> findAll() {
        Connection conn = null;
        List<News> newsList = new ArrayList<News>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select * from easybuy_news order by createTime desc");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                news.setCreateTime(format.parse(rs.getString("createTime")));
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return newsList;
    }

    @Override
    public int queryNewsCount() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select count(1) from easybuy_news ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return count;
    }

    @Override
    public List<News> queryNewsList(News n, Pager pager) {
        Connection conn = null;
        List<News> newsList = new ArrayList<News>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sql=new StringBuffer();
        sql.append("select * from easybuy_news ");
        try {
            conn = this.getConn();
            sql.append(" order by createTime desc limit ");
            if(pager.getCurrentPage()!=null) {
                sql.append(pager.getCurrentPage()*pager.getPageSize()-1);
                sql.append(","+pager.getPageSize());
            }

            pstmt = conn.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                news.setCreateTime(format.parse(rs.getString("createTime")));
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return newsList;
    }

    @Override
    public List<News> findTop5() {
        Connection conn = null;
        List<News> newsList = new ArrayList<News>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select * from easybuy_news order by createTime desc limit 5");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                news.setCreateTime(format.parse(rs.getString("createTime")));
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return newsList;
    }

}
