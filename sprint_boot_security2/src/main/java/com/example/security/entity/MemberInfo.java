package com.example.security.entity;

import java.io.Serializable;
import java.util.Date;

public class MemberInfo implements Serializable {
    private String id;

    private Date takeOfficeDate;

    private String password;

    private String memberName;

    private String memberNickname;

    private Date takeOfficeDateThisYear;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getTakeOfficeDate() {
        return takeOfficeDate;
    }

    public void setTakeOfficeDate(Date takeOfficeDate) {
        this.takeOfficeDate = takeOfficeDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname == null ? null : memberNickname.trim();
    }

    public Date getTakeOfficeDateThisYear() {
        return takeOfficeDateThisYear;
    }

    public void setTakeOfficeDateThisYear(Date takeOfficeDateThisYear) {
        this.takeOfficeDateThisYear = takeOfficeDateThisYear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", takeOfficeDate=").append(takeOfficeDate);
        sb.append(", password=").append(password);
        sb.append(", memberName=").append(memberName);
        sb.append(", memberNickname=").append(memberNickname);
        sb.append(", takeOfficeDateThisYear=").append(takeOfficeDateThisYear);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}