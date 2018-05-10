package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

public class Base implements Serializable {
    private Integer id;//id
    private String title;//标题
    private String context;//内容
    private Date createTime;//创建时间

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
