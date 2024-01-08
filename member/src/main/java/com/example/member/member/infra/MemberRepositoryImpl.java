package com.example.member.member.infra;

import com.example.member.member.command.domain.Member;
import com.example.member.member.command.domain.MemberJPARepository;
import com.example.member.member.command.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJPARepository memberJPARepository;

    @Override
    public Member save(Member member) {
        return memberJPARepository.save(member);
    }

    @Override
    public Optional<Member> findById(Member member) {
        return memberJPARepository.findById(member.getId());
    }

    @Override
    public Optional<Member> findByEmail(Member member) {
        return memberJPARepository.findByEmail(member.getEmail());
    }
}
