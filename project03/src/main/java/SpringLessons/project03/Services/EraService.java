package SpringLessons.project03.Services;

import SpringLessons.project03.Models.Era;
import SpringLessons.project03.Repositories.EraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EraService {
    private final EraRepository eraRepository;

    public EraService(EraRepository eraRepository) {
        this.eraRepository = eraRepository;
    }

    public List<Era> findAll() {
        return eraRepository.findAll();
    }

    public Era findById(Long id) {
        return eraRepository.findById(id).orElseThrow(() -> new RuntimeException("Age not found"));
    }

    public Era create(Era era) {
        return eraRepository.save(era);
    }

    public Era update(Long id, Era era) {
        Era found = findById(id);

        found.setName(era.getName());
        found.setAge(era.getAge());
        return eraRepository.save(found);
    }

    public void deleteById(Long id) {
        Era found = findById(id);
        eraRepository.delete(found);
    }
}
