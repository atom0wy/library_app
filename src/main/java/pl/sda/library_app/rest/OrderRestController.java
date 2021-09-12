package pl.sda.library_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.library_app.services.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@RequiredArgsConstructor
@Controller
public class OrderRestController {

    private final OrderService orderService;
}
