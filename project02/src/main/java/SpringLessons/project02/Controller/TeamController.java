package SpringLessons.project02.Controller;

import SpringLessons.project02.Model.Player;
import SpringLessons.project02.Model.Team;
import SpringLessons.project02.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/all")
    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team findById(@PathVariable Long id) {
        return teamRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found team brother."));
    }


    @GetMapping
    public Team findOne(@RequestParam String name){
        return null;
    }

    @PutMapping
    public Team update(@RequestBody Team team){
        return team;
    }
}
