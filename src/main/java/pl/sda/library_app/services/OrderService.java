package pl.sda.library_app.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.library_app.dto.BookDto;
import pl.sda.library_app.dto.MakeOrderForm;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.Order;
import pl.sda.library_app.repositories.OrderRepository;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookMapper bookMapper;

    public OrderService(OrderRepository orderRepository, BookMapper bookMapper) {
        this.orderRepository = requireNonNull(orderRepository);
        this.bookMapper = requireNonNull(bookMapper);
    }

    @Transactional
    public Long makeOrder(MakeOrderForm form) {
        final Order order = new Order(form.getCustomerId(), bookMapper.mapDtoToEntity(form.getBook()));
        orderRepository.save(order);
        return order.getId();
    }
}