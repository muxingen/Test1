package com.it.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long date = parameter.getTime();
        ps.setLong(i,date);
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long l = rs.getLong(columnName);
        Date date = new Date(l);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long l = rs.getLong(columnIndex);
        Date date = new Date(l);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long l = cs.getLong(columnIndex);
        Date date = new Date(l);
        return date;
    }
}
