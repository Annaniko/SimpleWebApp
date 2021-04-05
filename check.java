import model.UserEntity;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/check", urlPatterns = "/check")

public class check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("pass");
        String pass = request.getParameter("mail");
        String mail = request.getParameter("name");
        System.out.println(name);
        System.out.println(pass);
        System.out.println(mail);
        UserService userService = new UserService();

        UserEntity userEntity = new UserEntity(mail,name,pass);
        userService.saveUser(userEntity);
        response.sendRedirect("index.jsp");
    }

}
