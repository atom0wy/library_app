package pl.sda.library_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.services.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@RequiredArgsConstructor
@RestController
@WebServlet("/myservlet")
public class OrderRestController extends HttpServlet {

    private final OrderService orderService;

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getParameter("button1") != null) {
//            orderService.makeOrder();
//        }
//        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
//    }
}
