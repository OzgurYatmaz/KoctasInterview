package com.koctas.configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Value;
//Appender singleton patternde.
public class ConnectionFactory {
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }


    private Properties properties;
    private final DataSource dataSource;

    private ConnectionFactory() {
    	//-------------------

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        //------------------------------------
        
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Properties properties2 = new Properties();
        properties2.setProperty("user", properties.getProperty("spring.datasource.username"));
        properties2.setProperty("password", properties.getProperty("spring.datasource.password")); 

        GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<PoolableConnection>();
        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
        		properties.getProperty("spring.datasource.url"), properties2
        );
        new PoolableConnectionFactory(
                connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );

        this.dataSource = new PoolingDataSource(pool);
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
