package com.odontologica.main.persistence.dao.impl;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import com.odontologica.main.persistence.dao.util.ConfiguracionJDBC;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAOH2 implements Dao<Odontologo> {

    private Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    ConfiguracionJDBC jdbc = new ConfiguracionJDBC("org.h2.Driver", "jdbc:h2:~/Odontologica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "" );  // instanc

    @Override
    public Odontologo crear(Odontologo odontologo) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("INSERT into odontologos (Nombre, Apellido, NumeroMatricula) VALUES (?,?,?)");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNumeroMatricula());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            logger.info("Informacion Guardada correctamente");

        }catch (SQLException e) {
            logger.error("No se pudo guardar la informacion");
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public void eliminar(Long id) {

        jdbc.cargarElControlador();
        PreparedStatement preparedStatement = null;


        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("DELETE FROM odontologos where id= ? ");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Eliminacion registro No" + " " + id + " " + "fue exitosa");

        } catch (SQLException e) {
            logger.error("No se pudo eliminar el registro");
            e.printStackTrace();
        }

    }

    @Override
    public Odontologo consultarPorId(int id) {
        jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        Odontologo odontologo = null;

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos where id= ? ");
            preparedStatement.setLong(1, id);


            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                int idOdontologo = resultado.getInt("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");


                odontologo = new Odontologo();

                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setNumeroMatricula(NumeroMatriculaOdontologo);

            }

            preparedStatement.executeQuery();
            preparedStatement.close();

            logger.info("Consulta por ID No" + " " + id + " " + "fue exitosa");

        }catch (SQLException e) {
            logger.error("Presenta problemas la consulta por ID");
            e.printStackTrace();
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> consultarTodos() {

         jdbc.cargarElControlador();

        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList<>();

        try (Connection connetion = jdbc.conectarConBaseDeDatos()) {

            preparedStatement = connetion.prepareStatement("SELECT * FROM odontologos");

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()) {

                int idOdontologo = resultado.getInt("id");
                String nombreOdontologo = resultado.getString("nombre");
                String apellidoOdontologo = resultado.getString("apellido");
                String NumeroMatriculaOdontologo = resultado.getString("NumeroMatricula");

                Odontologo odontologo = new Odontologo();

                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setNumeroMatricula(NumeroMatriculaOdontologo);

                odontologos.add(odontologo);
            }

            preparedStatement.executeQuery();

            logger.info("Consulta de todos los registros fue exitosa");


        }catch (SQLException e) {
            logger.error("Consulta de todos los registros presento problemas");
            e.printStackTrace();
        }

        return odontologos;
    }
}
