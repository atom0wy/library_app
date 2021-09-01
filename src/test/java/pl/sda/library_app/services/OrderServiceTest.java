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

    @Test
    void shouldMakeOrderWithDefaultDeliveryCost() {
        // given
        final var user = new User();
        persistAndClearCache(user);
        final var form = new MakeOrderForm(user.getId(), List.of(new BookDto(123456L, "Power", "Bob Writer", "2020", "Fantasy", BookStatus.IN_STOCK)));

        // when
        final var orderId = orderService.makeOrder(form);

        // then
        assertNotNull(orderId);
        final var createdOrder = orderRepository.getById(orderId);
        assertEquals(orderId, createdOrder.getId());
    }

}