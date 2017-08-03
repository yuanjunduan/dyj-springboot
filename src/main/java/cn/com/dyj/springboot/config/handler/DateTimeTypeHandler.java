package cn.com.dyj.springboot.config.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


@MappedTypes(DateTime.class)
public class DateTimeTypeHandler implements TypeHandler<DateTime> {
  @Override
  public void setParameter(final PreparedStatement preparedStatement,
      final int parameterIndex, final DateTime dateTime, final JdbcType jdbcType) throws SQLException {
    if (dateTime != null) {
      preparedStatement.setTimestamp(parameterIndex, new Timestamp(dateTime.getMillis()));
    } else {
      preparedStatement.setTimestamp(parameterIndex, null);
    }
  }

  @Override
  public DateTime getResult(final ResultSet resultSet, final String columnName) throws SQLException {
    return toDateTime(resultSet.getTimestamp(columnName));
  }

  @Override
  public DateTime getResult(final ResultSet resultSet, final int columnIndex) throws SQLException {
    return toDateTime(resultSet.getTimestamp(columnIndex));
  }

  @Override
  public DateTime getResult(final CallableStatement callableStatement, final int columnIndex) throws SQLException {
    return toDateTime(callableStatement.getTimestamp(columnIndex));
  }

  private static DateTime toDateTime(final Timestamp timestamp) {
    DateTime datetime = null;
    if (timestamp != null) {
      datetime = new DateTime(timestamp.getTime(), DateTimeZone.UTC);
    }
    return datetime;
  }

}
