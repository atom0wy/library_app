package pl.sda.library_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.services.BooksService;

import java.util.List;

@Controller
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class MvcBrowseController {
    private final BooksService booksService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = booksService.getAll();
        model.addAttribute("books", books);
        return "catalog";
    }

    @PostMapping("/{id}/order")
    public String orderBook(@PathVariable Long id) {
        System.out.println("Ordered book " + id);
        return "catalog";
    }
}