/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.DetallePagoControllador;
import include.DetallePago;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;

/**
 *
 * @author Hawk
 */
public class GenerarPago extends HttpServlet {

    double sueldo_bruto = 0;
    String salud;
    Date fecha;
    int total;
    double ss;
    int sueldo_liquido;

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

        int id = Integer.parseInt(request.getParameter("id"));

        PreparedStatement pst = null;
        ResultSet rs = null;
        Conexion cn = new Conexion();

        try {
            String sql = "Call selectSueldoBruto(?)";
            pst = cn.getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                sueldo_bruto = rs.getDouble("sueldo_bruto");
                salud = rs.getString("salud");
                fecha = rs.getDate("fecha_contrato");
                total = rs.getInt("total");
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

        if (salud.equals("Isapre")) {
            sueldo_bruto -= sueldo_bruto * 0.07;
        } else {
            sueldo_bruto -= sueldo_bruto * 0.1;
        }
        sueldo_bruto -= sueldo_bruto * 0.1;
        sueldo_bruto += sueldo_bruto * 0.05;
        sueldo_bruto += sueldo_bruto * (0.15 * total);
        sueldo_bruto += sueldo_bruto * 0.18;
        sueldo_bruto -= sueldo_bruto * 0.15;
        ss = Math.round(sueldo_bruto);
        sueldo_liquido = (int)ss;

        DetallePago dp = new DetallePago(0,id, sueldo_liquido);
        DetallePagoControllador dpc = new DetallePagoControllador();
        if (dpc.crear(dp)) {
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
