package co.wedevx.digitalbank.automation.ui.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utilities.ConfigReader.getPropertiesValeu;

public class DB_Utils {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static void establishConnection (){
//
//        String url = "jdbc:mysql://3.249.240.23:3306/tetianac556";
//        String username = "tetianac556";
//        String password = "kqylhhrtderwxoxh";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(getPropertiesValeu("digitalbank.db.url"),
                    getPropertiesValeu("digitalbank.db.username"),
                    getPropertiesValeu("digitalbank.db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

//  1.  method to establish connection with db
//  2.  method that can dynamically send select statements and return a list of columns
public static List<Map<String,Object>> runSQLSelectQuery(String sqlQuery){
        List<Map<String, Object>>dbResultList = new ArrayList<>();
    try {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sqlQuery);
//        getMetaData () - returns info about your data;
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            Map<String, Object>rowMap = new HashMap<>();

            for(int column = 1; column <= columnCount; column++){
                rowMap.put(resultSetMetaData.getColumnName(column), resultSet.getObject(column));
            }
dbResultList.add(rowMap);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dbResultList;
}
//  3. method that inserts into db and return the number of rows updated
//    or zero when action was not performed
// 3.5   delete or truncate the table

    public static int runSQLUpdateQuery(String SQLQuery){
        int rowsAffected = 0;
        try {

            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(SQLQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
return rowsAffected;
    }
    public static void closeConnection(){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
//  4. method - close();  close connection
}
