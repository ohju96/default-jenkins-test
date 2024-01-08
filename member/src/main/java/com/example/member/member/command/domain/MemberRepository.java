package com.example.member.member.command.domain;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Member member);

    Optional<Member> findByEmail(Member member);
}
