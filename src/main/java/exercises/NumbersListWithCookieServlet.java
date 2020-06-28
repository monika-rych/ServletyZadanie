package exercises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/numbersWithCookie")
public class NumbersListWithCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String input = req.getParameter("upTo");
        Cookie cookie = new Cookie("mojaNazwaCiasteczka", input);
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
        int upTo;
        try {
            upTo = Integer.parseInt(input);

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
