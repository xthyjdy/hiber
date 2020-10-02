package classes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryItemWork implements org.hibernate.jdbc.Work {
  final protected Long itemId;
  ResultSet result = null;
  public QueryItemWork(Long itemId) {
	  this.itemId = itemId;
  }
  @Override
  public void execute(Connection connection) throws SQLException {
	  PreparedStatement statement = null;
	  ResultSet result = null;
	  try {
		  statement = connection.prepareStatement(
				  "select * from it where ID = ?"
		  );
		  statement.setLong(1, itemId);
		  result = statement.executeQuery();
		  List<Object> ls = new ArrayList<Object>();
		  
		  while (result.next()) {
			  String itemName = result.getString("name");
			  String desc = result.getString("des");
			  Long id = result.getLong("id");
			  ls.add(id);
			  ls.add(itemName);
			  ls.add(desc);
		  }
		  
		  System.out.println(ls);
	  } finally {
		  if (result != null)
			  result.close();
		  if (statement != null)
			  statement.close();
	  }
  }
  
  public ResultSet rs() {
	return result;
  }
}