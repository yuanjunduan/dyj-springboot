package cn.com.dyj.springboot.config.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@MappedTypes(DateTime.class)
public class JodaDateTimeTypeHandler implements TypeHandler {

  @Override
  public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

    Timestamp timestamp = null;

    if (parameter != null) {
      DateTime date = (DateTime) parameter;
      timestamp = Timestamp.valueOf(date.toString("yyyy-MM-dd HH:mm:ss"));
    }

    ps.setTimestamp(i, timestamp);
  }

  @Override
  public Object getResult(ResultSet rs, String columnName) throws SQLException {
    Object object = rs.getObject(columnName);

    if (rs.wasNull()) {
      return null;
    }

    if (object instanceof Date || object instanceof String) {
      return new DateTime(object);
    } else {
      return object;
    }

  }

  @Override
  public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
    Object object = cs.getObject(columnIndex);

    if (cs.wasNull()) {
      return null;
    }

    if (object instanceof Date || object instanceof String) {
      return new DateTime(object);
    } else if (object instanceof Timestamp) {
      Timestamp time = (Timestamp) object;
      return new DateTime(time.getTime());
    } else {
      return object;
    }

  }

  @Override
  public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
    Object object = rs.getObject(columnIndex);

    if (rs.wasNull()) {
      return null;
    }

    if (object instanceof Date || object instanceof String) {
      return new DateTime(object);
    } else {
      return object;
    }
  }

}
