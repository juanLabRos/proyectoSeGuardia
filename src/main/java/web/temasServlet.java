/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dominio.Examen;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.iexamenService;

/**
 *
 * @author Jon
 */
@WebServlet("/examenes")
public class temasServlet extends HttpServlet {
    // Ahora hacemos la inyección del componente EJB local al servlet

    @Inject
    // Ahora definimos nuestra variable
    iexamenService examenService;
    
// Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
            throws ServletException, IOException {

        /**
         * Ahora este método va acceder al listado de personas por medio de la
         * instancia que estamos recibiendo el EJB
         */
        List<Examen> examen = examenService.findAllExamen();
        System.out.println("examenes: " + examen);

        // Ponemos personas en un alcance
        request.setAttribute("Examenes:", examen);

        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoExamenes.jsp").forward(request,
                respose);
    }
    
   
 
}
