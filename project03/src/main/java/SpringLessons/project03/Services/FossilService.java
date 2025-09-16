package SpringLessons.project03.Services;

import SpringLessons.project03.Dto.FossilDTO;
import SpringLessons.project03.Models.Category;
import SpringLessons.project03.Models.Era;
import SpringLessons.project03.Models.Fossil;
import SpringLessons.project03.Repositories.CategoryRepository;
import SpringLessons.project03.Repositories.EraRepository;
import SpringLessons.project03.Repositories.FossilRepository;
import SpringLessons.project03.Repositories.FossilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FossilService {
    private FossilRepository fossilRepository;
    private CategoryRepository categoryRepository;
    private EraRepository eraRepository;

    public FossilService(FossilRepository fossilRepository,  CategoryRepository categoryRepository, EraRepository eraRepository) {
        this.fossilRepository = fossilRepository;
        this.categoryRepository = categoryRepository;
        this.eraRepository = eraRepository;
    }

    public List<Fossil> findAll() {
        return fossilRepository.findAll();
    }

    public Fossil create(FossilDTO fossildto) {
        Era era = eraRepository.findById(fossildto.era_id())
                .orElseThrow(() -> new RuntimeException("Era not found with id: " + fossildto.era_id()));

        Category category = categoryRepository.findById(fossildto.category_id())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + fossildto.category_id()));

        Fossil newFossil = new Fossil();
        newFossil.setName(fossildto.name());
        newFossil.setDescription(fossildto.description());
        newFossil.setAge(fossildto.age());
        newFossil.setEra(era);
        newFossil.setCategory(category);

        return fossilRepository.save(newFossil);
    }

    public Fossil findById(Long id) {
        return fossilRepository.findById(id).orElseThrow(() -> new RuntimeException("You dont have this fossil"));
    }

    public Fossil update(Long id, Fossil updatedFossil) {
        Fossil foundFossil = findById(id);

        foundFossil.setName(updatedFossil.getName());
        return fossilRepository.save(foundFossil);
    }

    public void deleteById(Long id) {
        Fossil foundFossil = findById(id);
        fossilRepository.delete(foundFossil);
    }
}
