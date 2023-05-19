package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;

import modeloInventario.*;

public class DaoInventario {

    private Connection con = null;

    public DaoInventario() throws SQLException {

        con = DBConexionTabigal.getConnection();
        //Conectamos con base de datos de Intentario tabigal
    }


    public ArrayList<Inventario> obtener() throws SQLException {

        

        PreparedStatement ps = con.prepareStatement("SELECT * FROM portatiles ");
        
        ResultSet rs = ps.executeQuery();

        ArrayList<Inventario> i =null;
        
        while (i== null){

            if (== null){
            i = new ArrayList<>();
        }

        i.add(new Inventario(rs.getString("empresa"),rs.getString("empresaUsuario"),rs.getString("usuario"),rs.getString("departamento"), rs.getString("autorizadoPor"),rs.getString("autorizadoHasta"), rs.getString("office"), rs.getString("antivirus"), rs.getString("modelo"), rs.getString("numSerie"), rs.getString("baja"), rs.getString("notas"), rs.getString("accionPendiente"), rs.getString("procesador"), rs.getString("ram"), rs.getString("win11"),rs.getString("hd"),rs.getString("identificador")));
        }

        

        return i;
    }
    
}
