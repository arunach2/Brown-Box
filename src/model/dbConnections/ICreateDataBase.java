package model.dbConnections;

import java.sql.Connection;

public interface ICreateDataBase {
    Connection createConnection();
}
