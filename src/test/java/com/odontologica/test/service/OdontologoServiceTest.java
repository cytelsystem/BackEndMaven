package com.odontologica.test.service;

import com.odontologica.main.model.Odontologo;
import com.odontologica.main.persistence.dao.impl.OdontologoDAOH2;
import com.odontologica.main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OdontologoServiceTest {

    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OdontologoServiceTest.class);

    OdontologoService odontologoService = new OdontologoService();
    private Assertions Assert;

    @Test
    void guardaOdontologoEnBaseDatos() {

        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());

        Odontologo odontologo = new Odontologo();

        odontologo.setNombre("Hector");
        odontologo.setApellido("moreno");
        odontologo.setNumeroMatricula("79904519");
        odontologoService.guardaOdontologoService(odontologo);

    }
    @Test
    void guarda() {

        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());

        Odontologo odontologo = new Odontologo();

        odontologo.setNombre("Hector");
        odontologo.setApellido("moreno");
        odontologo.setNumeroMatricula("79904519");
        odontologoService.guardaOdontologoService(odontologo);


        Assertions.assertEquals("Hector", odontologo.getNombre());


    }


    @Test
    void eliminarOdontologoPorID() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());
        odontologoService.eliminar(16L);
    }




    @Test
    void buscarOdontoPorID() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());
        odontologoService.buscarOdontologoService(17);
    }

    @Test
    public void _01_deberíaConsultarExitosamenteTodosLosOdontologosDeLaBaseDeDatos(){

        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());
        List<Odontologo> resultado = odontologoService.listarTodosServices();

        Assertions.assertTrue(resultado.size() > 0);


    }


    @Test
    void ListarTodosOdontologos() {
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());

        int ListarTodo = odontologoService.listarTodosServices().size();

        for (int i=0; i< ListarTodo; i++) {
            Odontologo registros = odontologoService.listarTodosServices().get(i);
        }

    }



}
