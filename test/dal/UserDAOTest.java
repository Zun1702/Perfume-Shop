package dal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class UserDAOTest {

    private UserDAO userDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        userDAO = new UserDAO();
        userDAO.connection = mockConnection; // Inject mock connection into DAO
    }

    @Test
    public void testAddUser() throws SQLException {
        // Arrange
        String username = "testuser";
        String password = "testpassword";
        String email = "testuser@example.com";
        
        String expectedSQL = "insert into Users values(1, 2, null, null, ?, ?, ?, null,? , null, 0, ?)";
        
        // Mocking
        when(mockConnection.prepareStatement(expectedSQL)).thenReturn(mockPreparedStatement);

        // Act
        userDAO.addUser(username, password, email);

        // Assert
        verify(mockPreparedStatement).setString(1, username);
        verify(mockPreparedStatement).setString(2, password);
        verify(mockPreparedStatement).setString(3, email);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
