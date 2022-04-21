package dao;

import java.util.List;
import model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import services.UtilToSql;

public class PersonaImpl extends Conexion implements ICRUD<Persona> {

    @Override
    public void guardar(Persona persona) throws Exception {
        Date fecha = (Date) persona.getFecha();
        System.out.println("Fecha directa :" + UtilToSql.convert(persona.getFecha()));
        System.out.println("Fecha con (Date):" + UtilToSql.convert(fecha));

        try {
            String sql = "insert into PERSONA"
                    + " (NOMPER,APEPER,FECNAC,DNIPER,DIRECC,TELFPER,TIPPER,ESTPER)"
                    + " values (?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setDate(3, UtilToSql.convert(persona.getFecha()));
            ps.setString(4, persona.getDni());
            ps.setString(5, persona.getDirreccion());
            ps.setString(6, persona.getTelefono());
            ps.setString(7, persona.getTipo());
            ps.setString(8, persona.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PersonaImpl/registrar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Persona persona) throws Exception {
        try {
            String sql = "update PERSONA set NOMPER=?,APEPER=?,DNIPER=?,DIRECC=?,FECNAC=?,TELFPER=?,TIPPER=?,ESTPER=? where CODPER=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getDni());
            ps.setString(4, persona.getDirreccion());
            ps.setDate(5, UtilToSql.convert(persona.getFecha()));
            ps.setString(6, persona.getTelefono());
            ps.setString(7, persona.getTipo());
            ps.setString(8, "A");
            ps.setInt(9, persona.getCodigopersona());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PersonaImpl/modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        try {
            String sql = "delete from PERSONA where codper=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, persona.getCodigopersona());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en PersonaImpl/eliminar: " + e.getMessage());
        }
    }

    
    @Override
    public List<Persona> listarTodos() throws Exception {
        List<Persona> lista = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from PERSONA order by CODPER desc";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Persona per = new Persona();
                per.setCodigopersona(rs.getInt("CODPER"));
                per.setNombre(rs.getString("NOMPER"));
                per.setApellido(rs.getString("APEPER"));
                per.setDni(rs.getString("DNIPER"));
                per.setDirreccion(rs.getString("DIRECC"));
                per.setFecha(rs.getDate("FECNAC"));
                per.setTelefono(rs.getString("TELFPER"));
                per.setTipo(rs.getString("TIPPER"));
                per.setEstado(rs.getString("ESTPER"));
                lista.add(per);
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {
            this.cerrarCnx();
        }
        return lista;
    }

    public void cambiarEstado(Persona persona) throws Exception {
        try {
            String sql = "update persona set ESTPER=? where CODPER=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getEstado());
            ps.setInt(2, persona.getCodigopersona());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en PersonaImpl/cambiarEstado: " + e.getMessage());
        }
    }
}


   