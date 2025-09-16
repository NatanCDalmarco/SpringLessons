package SpringLessons.project03.Controllers;

import SpringLessons.project03.Models.Era;
import SpringLessons.project03.Services.EraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/era")
public class EraController {
    private EraService eraService;

    public EraController(EraService eraService) {
        this.eraService = eraService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Era>> findAll() {
        return ResponseEntity.ok(eraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(eraService.findById(id));
        } catch (Exception e) {
            return buildErrorResponse("Age not found", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Era> create(@RequestBody Era era) {
        Era savedEra = eraService.create(era);
        return new  ResponseEntity<>(savedEra, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Era era) {
        try {
            return ResponseEntity.ok(eraService.update(id, era));
        } catch (Exception e) {
            return buildErrorResponse("Not possible to ", e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            eraService.deleteById(id);
            return ResponseEntity.ok("Age deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent Age", e.getMessage(), HttpStatus.NOT_FOUND);
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
