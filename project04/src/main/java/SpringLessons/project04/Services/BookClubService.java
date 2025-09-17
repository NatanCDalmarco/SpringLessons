package SpringLessons.project04.Services;

import SpringLessons.project04.Dtos.BookClubDto;
import SpringLessons.project04.Mappers.BookClubMapper;
import SpringLessons.project04.Models.BookClub;
import SpringLessons.project04.Repositories.BookClubRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookClubService {
    BookClubRepository bookClubRepository;
    BookClubMapper bookClubMapper;

    public BookClubService(BookClubRepository bookClubRepository, BookClubMapper bookClubMapper) {
        this.bookClubRepository = bookClubRepository;
        this.bookClubMapper = bookClubMapper;
    }

    public BookClub getById(Long id) {
        return bookClubRepository.findById(id).orElseThrow(() -> new RuntimeException("BookClub with id " + id + " not found"));
    }

    public List<BookClub> getAll() {
        return bookClubRepository.findAll();
    }

    public BookClub create(BookClubDto bookClubDto) {
        BookClub bookClub = bookClubMapper.toEntity(bookClubDto);
        bookClub.setCreationDate(LocalDate.now());

        return bookClubRepository.save(bookClub);
    }

    public BookClub update(Long id,BookClubDto bookClubDto) {
        BookClub bookClub = getById(id);
        bookClubMapper.updateEntityFromDto(bookClubDto, bookClub);

        return bookClubRepository.save(bookClub);
    }

    public void delete(Long id) {
        BookClub bookClub = getById(id);
        bookClubRepository.delete(bookClub);
    }
}
