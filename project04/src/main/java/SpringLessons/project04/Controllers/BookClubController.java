package SpringLessons.project04.Controllers;

import SpringLessons.project04.Dtos.BookClubDto;
import SpringLessons.project04.Models.BookClub;
import SpringLessons.project04.Services.BookClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookclubs")
public class BookClubController {
    private final BookClubService bookclubService;

    @Autowired
    public BookClubController(BookClubService bookclubService) {
        this.bookclubService = bookclubService;
    }

    @GetMapping
    public List<BookClub> getAll()
    {
        return bookclubService.getAll();
    }

    @GetMapping("/{id}")
    public BookClub getById(@PathVariable Long id)
    {
        return bookclubService.getById(id);
    }

    @PostMapping
    public BookClub create(@RequestBody BookClubDto bookclubDto)
    {
        return bookclubService.create(bookclubDto);
    }

    @PutMapping("/{id}")
    public BookClub update(@RequestBody BookClubDto bookclubDto,  @PathVariable Long id) {
        return bookclubService.update(id, bookclubDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            bookclubService.delete(id);
            return ResponseEntity.ok("BookClub deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent BookClub", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status);
        body.put("error", error);
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }
}
