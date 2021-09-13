package pl.sda.library_app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.library_app.dto.BookDto;
import pl.sda.library_app.dto.MakeOrderForm;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.User;
import pl.sda.library_app.repositories.OrderRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderServiceTest extends BaseServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

//    @Test
//    void shouldMakeOrder() {
//        // given
//        final var user = new User();
//        final var bookDto = new BookDto("Power", "Bob Writer", "2020", "Fantasy", BookStatus.IN_STOCK);
//        final var bookDto2 = new BookDto("Weakness", "Bob Writer", "2020", "Fantasy", BookStatus.IN_STOCK);
//        persistAndClearCache(user);
//        final var form = new MakeOrderForm(user.getId(), bookDto);
//
//        // when
//        final var orderId = orderService.makeOrder(form);
//
//        // then
//        assertNotNull(orderId);
//        final var createdOrder = orderRepository.getById(orderId);
//        assertEquals(orderId, createdOrder.getId());
//    }

}