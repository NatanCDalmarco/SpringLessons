package SpringLessons.project04.Services;

import SpringLessons.project04.Dtos.MemberDto;
import SpringLessons.project04.Mappers.MemberMapper;
import SpringLessons.project04.Models.BookClub;
import SpringLessons.project04.Models.Member;
import SpringLessons.project04.Repositories.BookClubRepository;
import SpringLessons.project04.Repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    BookClubRepository bookClubRepository;
    MemberRepository memberRepository;
    MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper, BookClubRepository bookClubRepository) {
        this.memberRepository = memberRepository;
        this.bookClubRepository = bookClubRepository;
        this.memberMapper = memberMapper;
    }

    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member with id " + id + " not found"));
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public Member create(MemberDto memberDto) {
        BookClub bookClub = bookClubRepository.findById(memberDto.bookclub_id())
                .orElseThrow(() -> new RuntimeException("BookClub não encontrado com o ID: " + memberDto.bookclub_id()));

        Member member = memberMapper.toEntity(memberDto);
        member.setJoinDate(LocalDate.now());
        member.setClub(bookClub);

        return memberRepository.save(member);
    }

    public Member update(Long id,MemberDto memberDto) {
        Member member = getById(id);
        memberMapper.updateEntityFromDto(memberDto, member);

        return memberRepository.save(member);
    }

    public void delete(Long id) {
        Member member = getById(id);
        memberRepository.delete(member);
    }
}
