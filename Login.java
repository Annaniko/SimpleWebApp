import model.UserEntity;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/Login", urlPatterns = "/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name);
        System.out.println(pass);
        UserEntity user = UserService.findUser(name);
        if (user == null){
            response.sendRedirect("index.jsp");
            return;
        }

        if (user.getPassword().equals(pass)){
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("register.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
