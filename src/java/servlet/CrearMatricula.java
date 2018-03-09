/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.MatriculaController;
import include.Alumno;
import include.Carrera;
import include.Ciclo;
import include.Institucion;
import include.Matricula;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hawk
 */
public class CrearMatricula extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String sexo = request.getParameter("sexo");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        int id_carrera_fk = Integer.parseInt(request.getParameter("carrera"));
        String semestre = request.getParameter("semestre");
        int id_institucion_fk = Integer.parseInt(request.getParameter("institucion"));
        String modalidad = request.getParameter("modalidad");
        String ciclo = request.getParameter("ciclo");
        double monto = Double.parseDouble(request.getParameter("monto"));
        
        
        Alumno a = new Alumno(rut, nombre, apellidos, sexo, direccion, telefono, email);
        Matricula m =  new Matricula(semestre, monto, modalidad);
        Institucion i = new Institucion(id_institucion_fk);
        Carrera c = new Carrera(id_carrera_fk);
        Ciclo ci = new Ciclo(ciclo);
        MatriculaController mc = new MatriculaController();
        if (mc.crear(m, a, i, c, ci)) {
            response.getWriter().print("1");
        } else {
            response.getWriter().print("2");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
