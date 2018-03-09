/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.UsuarioController;
import include.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Conexion;

/**
 *
 * @author Hawk
 */
public class Autenticar extends HttpServlet {

    String tipoUsuario;
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
        
        String nombreUsuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        Usuario u = new Usuario(nombreUsuario, pass);
        UsuarioController cu = new UsuarioController();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        Conexion cn = new Conexion();

        try {
            String sql = "Call selectTipoUsuario(?)";
            pst = cn.getConnection().prepareCall(sql);
            pst.setString(1, nombreUsuario);
            rs = pst.executeQuery();
            while (rs.next()) {
                tipoUsuario = rs.getString("tipo_usuario");
            }
        } catch (Exception e) {
        } finally {
            try {
                if (cn.getConnection() != null) {
                    cn.getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }
        
        if (cu.validar(u)) {
            response.getWriter().print("1");
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("tipoUsuario", tipoUsuario);
            sesion.setAttribute("nombreUsuario", nombreUsuario);
        }else{
            response.getWriter().print("0");
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
