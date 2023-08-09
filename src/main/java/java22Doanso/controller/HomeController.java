package java22Doanso.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = { "/index" })
public class HomeController extends HttpServlet {
	Random random = new Random();
	int secretNumber = random.nextInt(1000) + 1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "Vui Long nhap so");

		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer number = Integer.parseInt(req.getParameter("number"));
		String message = "";
		
		if (number > secretNumber) {
			message = "Số vừa đoán lớn hơn đáp án";
		} else if (number < secretNumber) {
			message = "Số vừa đoán nho hơn đáp án";
		} else if (number == secretNumber) {
			message = "Ban doan dung roi";
		}
		else {
			message = "Looix";
		}
		System.out.println(secretNumber);
		System.out.println(number);
		req.setAttribute("message", message);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
