package SpringLessons.project02.Controller;

import SpringLessons.project02.Model.Manager;
import SpringLessons.project02.Model.Team;
import SpringLessons.project02.Repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/all")
    public List<Manager> findAll(){
        return managerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Manager findById(@PathVariable Long id) {
        return managerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found manager my brother."));
    }

//    @GetMapping("/team/{team_id}")
//    public List<Manager> findByTeam_Id(@PathVariable Long team_id){
//        return managerRepository.findByTeam_Id(team_id);
//    }


    @PutMapping
    public Manager update(@RequestBody Manager manager){
        return managerRepository.save(manager);
    }

    @PostMapping
    public Manager save(@RequestBody Manager manager){
        return managerRepository.save(manager);
    }

    @DeleteMapping
    public void delete(@RequestBody Manager manager){
        managerRepository.delete(manager);
    }
}
