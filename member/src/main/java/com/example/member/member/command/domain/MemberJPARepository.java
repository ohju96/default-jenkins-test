package com.example.member.member.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
