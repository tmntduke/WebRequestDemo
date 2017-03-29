package Servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tmnt on 2017/2/8.
 */
@WebServlet(name = "PrintServlet")
public class PrintServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        ReadUrl readUrl = new ReadUrl();

        String str = readUrl.getUrl();

        System.out.println(str);

        JSONArray array = JSONArray.fromObject(str);

        System.out.println("size:" + array.size());

        List<FileInfo> list = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JSONObject o = array.getJSONObject(i);
            FileInfo info = (FileInfo) JSONObject.toBean(o, FileInfo.class);
            list.add(info);
        }

        System.out.println("this is :" + list.get(2).getName() + "  path:" + list.get(2).getPath());


        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name.equals("admin") && pass.equals("1234")) {
            writer.print(str);
        }

        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
