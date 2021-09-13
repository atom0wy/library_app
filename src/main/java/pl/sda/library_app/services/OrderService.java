package pl.sda.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.library_app.dto.MakeOrderForm;
import pl.sda.library_app.models.Order;
import pl.sda.library_app.repositories.OrderRepository;

import static java.util.Objects.requireNonNull;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookMapper bookMapper;

    public OrderService(OrderRepository orderRepository, BookMapper bookMapper) {
        this.orderRepository = requireNonNull(orderRepository);
        this.bookMapper = requireNonNull(bookMapper);
    }

    @Transactional
    public Long makeOrder(Long bookId, String username) {
        final Order order = new Order();
        orderRepository.save(order);
        return order.getId();
    }
}