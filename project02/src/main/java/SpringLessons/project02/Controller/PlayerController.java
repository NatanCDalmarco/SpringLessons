package SpringLessons.project02.Controller;

import SpringLessons.project02.Model.Player;
import SpringLessons.project02.Model.Team;
import SpringLessons.project02.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/all")
    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable Long id) {
        return playerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found player brother."));
    }

    @PutMapping
    public Team update(@RequestBody Team team){
        return team;
    }

    @PostMapping
    public Player save(@RequestBody Player player){
        return player;
    }

    @DeleteMapping
    public void deleteById(@RequestParam String name){
    }
}
