package jp.yattom.pairpro.sudoku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String quiz = req.getParameter("quiz");
        req.setAttribute("quiz", quiz);
        Sudoku sudoku = new Sudoku(quiz);
        req.setAttribute("sudoku", sudoku);
        System.err.println(sudoku);
        req.getRequestDispatcher("/WEB-INF/solved.jsp").forward(req, resp);
    }

}
