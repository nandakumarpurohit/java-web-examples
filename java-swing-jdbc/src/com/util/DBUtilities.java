package com.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtilities {

    private static Connection dbConnection = null;
    private static Statement statement = null;

    public static Connection getConnection()
    {
        if (dbConnection != null)
        {
            return dbConnection;
        }
        else
        {
            try
            {
                InputStream inputStream = DBUtilities.class.getClassLoader().getResourceAsStream("db.properties");

                Properties properties = new Properties();

                properties.load(inputStream);

                String dbDriver = properties.getProperty("dbDriver");
                String connectionUrl = properties.getProperty("connectionUrl");
                String userName = properties.getProperty("userName");
                String password = properties.getProperty("password");

                Class.forName(dbDriver).newInstance();
                dbConnection = DriverManager.getConnection(connectionUrl, userName, password);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return dbConnection;
        }
    }

    public static void ExecuteSQLStatement(String sql_stmt)
    {
        try {
            statement = getConnection().createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}