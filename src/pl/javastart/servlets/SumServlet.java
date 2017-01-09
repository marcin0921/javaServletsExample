package pl.javastart.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Hello World!!\n");
        out.print(sum(showRequests(request, response)));

    }

    HashMap<String, Integer> showRequests (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HashMap<String, Integer> requestsMap = new HashMap<>();

        Enumeration en = request.getParameterNames();

        while(en.hasMoreElements()) {
            Object obj = en.nextElement();
            String param = (String) obj;
            try {
                int value = Integer.parseInt(request.getParameter(param));
                requestsMap.put(param, value);
            }catch(Exception e) {
                out.print("Bledne dane dla: " + param + "\n");
            }
        }
        out.print(requestsMap);
        return requestsMap;
    }

    String sum (HashMap<String, Integer> requestsMap) {

        int result = 0;

        for(Map.Entry<String, Integer> entry: requestsMap.entrySet()) {
            result += entry.getValue();
        }

        return "\nSuma: " + result;
    }

}
