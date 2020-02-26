/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Utilidades;

/**
 *
 * @author pilar
 */
@WebServlet(name = "horoscopo", urlPatterns = {"/horoscopo"})
public class horoscopo extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet horoscopo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet horoscopo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ArrayList<String> meses = Utilidades.getMeses();
        ArrayList<String> dias = Utilidades.getDias(meses);
        request.setAttribute("meses", meses);
        request.setAttribute("dias", dias);
        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
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
        ArrayList<String> meses = Utilidades.getMeses();
        ArrayList<String> dias = Utilidades.getDias(meses);
        request.setAttribute("meses", meses);
        request.setAttribute("dias", dias);
        
        String nombre = request.getParameter("nombre");
        String mes = request.getParameter("mes");
        String dia = request.getParameter("dia");
        String signo = Utilidades.getHoroscopo(Integer.parseInt(dia), Integer.parseInt(mes));
        
        request.setAttribute("nombre", nombre);
        request.setAttribute("dia", dia);
        request.setAttribute("mes", mes);
        request.setAttribute("signo", signo);
        request.getRequestDispatcher("horoscopo.jsp").forward(request, response);
        
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