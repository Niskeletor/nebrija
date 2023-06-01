import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import java.sql.*;

public class UsuarioDaoTest {

    @Test
    public void verificarUsuarioTest() throws SQLException {

        // Crear mock de los objetos
        Connection con = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        // Configurar el comportamiento de los mocks
        when(con.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);

        // Crear una instancia del objeto a probar
        UsuarioDao dao = new UsuarioDao(con);

        // Crear un Login ficticio
        Login login = new Login("nombreUsuario", "contrasenia");

        // Llamar al método a probar
        boolean existe = dao.verificarUsuario(login);

        // Verificar el resultado
        assertTrue(existe);
    }
}
