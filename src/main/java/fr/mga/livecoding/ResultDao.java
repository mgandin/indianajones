package fr.mga.livecoding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDao {

	public static List<Result> query() {
		List<Result> results = new ArrayList<Result>();
		try {
			Class.forName("org.h2.Driver").newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
		try {
            String url = ResultDao.class.getClassLoader().getResource("./db").getPath();

            connection = DriverManager.getConnection("jdbc:h2:file:" + url + "/h2test.db",
					"sa", "");
			preparedStatement = connection.prepareStatement("Select departement,manager,netprofit,operatingexpense,year,turnover from result");
	    	
			resultSet = preparedStatement.executeQuery();
	    	
	    	while(resultSet.next()) {
	    		Result result = new Result();
	    		result.setDepartement(resultSet.getString("departement"));
	    		result.setManager(resultSet.getString("manager"));
	    		result.setNetProfit(resultSet.getDouble("netprofit"));
	    		result.setOperatingExpense(resultSet.getDouble("operatingexpense"));
                result.setYear(resultSet.getInt("year"));
                result.setTurnover(resultSet.getInt("turnover"));
	    		results.add(result);
	    	}
	    	
	    	return results;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
    	
    	
	}

}
