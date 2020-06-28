package exercises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/numbers")
public class NumbersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int upTo;
        try {
            upTo = Integer.parseInt(req.getParameter("upTo"));

        } catch (NumberFormatException e) {
            resp.getWriter().println("Argument format not recognized");
            return;
        }
        if(upTo < 1){
            return;
        }

        for(int i = 1; i <= upTo; i++){
            resp.getWriter().println(i);
        }
    }
}
