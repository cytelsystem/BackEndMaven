package com.odontologica.main.service;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.Dao;
import java.util.List;


public class OdontologoService {

    private Dao<Odontologo> odontologoIDAO; // comunicacion con la interface

    //******************************Getter***************************************//
    public Dao<Odontologo> getOdontologoIDAO() {

        return odontologoIDAO;
    }
    //******************************Setter***********************************************//


    public void setOdontologoIDAO(Dao<Odontologo> odontologoIDAO) {

        this.odontologoIDAO = odontologoIDAO;
    }

    //*****************************Metodos************************************************//

    public  Odontologo guardaOdontologoService(Odontologo o) {

        return odontologoIDAO.crear(o);
    }



    public void eliminar(Long id) {
        odontologoIDAO.eliminar(id);
    }

    public  Odontologo buscarOdontologoService(int id) {

        return odontologoIDAO.consultarPorId(id);
    }

    public List<Odontologo> listarTodosServices() {

        return odontologoIDAO.consultarTodos();


    }

    //********************************************************************************//


}