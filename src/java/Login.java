/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ModelUser;

/**
 *
 * @author hilmiat
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
            String action = request.getParameter("action");
            if(action!=null&&action.equals("logout")){
                request.getSession().invalidate();
            }
            String halaman = "/pages/login.jsp";      
            if(action!=null&&action.equals("register")){
                halaman = "/pages/register.jsp";
            }
            RequestDispatcher rd = 
                    getServletContext().getRequestDispatcher(halaman);
            rd.include(request, response);
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
//        processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        ModelUser muser = new ModelUser();
        
        String action = request.getParameter("action");
        System.out.println("Login.doPost()-->action:"+action);
        if(action!=null && action.equals("register")){
            System.out.println("Login.doPost()-->action:"+action);
            String fullname = request.getParameter("fullname");
            String repeatpassword = request.getParameter("passwordrepeat");
            //cek password
            if(password.equals(repeatpassword)){
                //register data
                System.out.println("Register data");
                User user_baru = new User();
                user_baru.setEmail(username);
                user_baru.setFullname(fullname);
                user_baru.setPassword(password);
                muser.register(user_baru);
            }
        }
        
        RequestDispatcher rd;
//        ModelUser muser = new ModelUser();
        User user = muser.auth(username, password);
        if(user!=null){
            HttpServletRequest pageContext = request;
            HttpSession session = pageContext.getSession();
//            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect(request.getContextPath()+"/Dashboard");
//            request.setAttribute("user",user);
//            rd = getServletContext().getRequestDispatcher("/Dashboard");
        }else{
            request.setAttribute("message","Username atau password salah");
            rd = getServletContext().getRequestDispatcher("/pages/login.jsp");
            rd.forward(request, response);
        }
        
        
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
