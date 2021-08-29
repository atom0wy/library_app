package pl.sda.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.library_app.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
public class BookRentalService {

    private final OrderRepository bookRentalRepository;
}
