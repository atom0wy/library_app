package pl.sda.library_app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.library_app.repositories.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
}
