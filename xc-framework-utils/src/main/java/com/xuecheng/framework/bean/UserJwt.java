package com.xuecheng.framework.bean;

import java.util.Objects;

/**
 * XcOauth2Util的实体
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/10
 */
public class UserJwt {
    private String id;
    private String name;
    private String userpic;
    private String utype;
    private String companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "UserJwt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userpic='" + userpic + '\'' +
                ", utype='" + utype + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserJwt userJwt = (UserJwt) o;
        return Objects.equals(id, userJwt.id) &&
                Objects.equals(name, userJwt.name) &&
                Objects.equals(userpic, userJwt.userpic) &&
                Objects.equals(utype, userJwt.utype) &&
                Objects.equals(companyId, userJwt.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userpic, utype, companyId);
    }

}
