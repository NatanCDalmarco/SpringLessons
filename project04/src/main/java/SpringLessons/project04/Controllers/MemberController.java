package SpringLessons.project04.Controllers;

import SpringLessons.project04.Dtos.MemberDto;
import SpringLessons.project04.Models.Member;
import SpringLessons.project04.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAll()
    {
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id)
    {
        return memberService.getById(id);
    }

    @PostMapping
    public Member create(@RequestBody MemberDto memberDto)
    {
        return memberService.create(memberDto);
    }

    @PutMapping("/{id}")
    public Member update(@RequestBody MemberDto memberDto,  @PathVariable Long id) {
        return memberService.update(id, memberDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            memberService.delete(id);
            return ResponseEntity.ok("Member deleted successfully");
        } catch (Exception e) {
            return buildErrorResponse("Can't delete inexistent Member", e.getMessage(), HttpStatus.NOT_FOUND);
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
