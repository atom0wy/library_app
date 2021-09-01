package pl.sda.library_app.services;

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

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = requireNonNull(orderRepository);
    }

    @Transactional
    public Long makeOrder(MakeOrderForm form) {
        final Order order = new Order(form.getCustomerId(), mapBooks(form.getBooks()));
        orderRepository.save(order);
        return order.getId();
    }

    private List<Book> mapBooks(List<BookDto> books) {
        return books.stream()
                .map(b -> new Book(b.getId(), b.getTitle(),
                        b.getAuthor(), b.getYearOfRelease(),
                        b.getGenre(), b.getStatus()))
                .collect(toList());
    }
}