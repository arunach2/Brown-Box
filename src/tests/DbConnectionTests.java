package tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import model.dbConnections.CreateBrownBoxDataBase;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DbConnectionTests {
    @Test
    public void testDbConnectionWorks () {
        Connection mockConnection = new CreateBrownBoxDataBase().createConnection();
        assertNotNull(mockConnection);
    }
}
