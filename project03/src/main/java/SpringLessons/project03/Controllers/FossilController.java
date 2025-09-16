package SpringLessons.project03.Controllers;

import SpringLessons.project03.Dto.FossilDTO;
import SpringLessons.project03.Models.Fossil;
import SpringLessons.project03.Repositories.FossilRepository;
import SpringLessons.project03.Services.FossilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fossil")
public class FossilController {
    private FossilService fossilService;

    public FossilController(FossilService fossilService) {
        this.fossilService = fossilService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fossil>> findAll() {
        return ResponseEntity.ok(fossilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fossilService.findById(id));
        } catch (Exception e) {
            return buildErrorResponse("Fossil not found", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Fossil> create(@RequestBody FossilDTO fossilDTO) {
        Fossil newFossil = fossilService.create(fossilDTO);
        return new ResponseEntity<>(newFossil, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Fossil fossil) {
        try {
            return ResponseEntity.ok(fossilService.update(id, fossil));
        } catch (Exception e) {
            return buildErrorResponse("Not possible to ", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            fossilService.deleteById(id);
            return ResponseEntity.ok("Fossil deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent Fossil", e.getMessage(), HttpStatus.NOT_FOUND);
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
