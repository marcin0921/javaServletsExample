package pl.javastart.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class PostExampleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        List<Integer> valuesFromRequest = new ArrayList<>();

        Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            Object obj = en.nextElement();
            String param = (String)obj;
            try {
                int value = Integer.parseInt(req.getParameter(param));
                valuesFromRequest.add(value);
            }catch (Exception e) {
                out.print("Bledne dane dla: " + param + "\n");
            }
        }
        Collections.sort(valuesFromRequest);
        out.print("Posortowana lista: " + valuesFromRequest);



    }

}
