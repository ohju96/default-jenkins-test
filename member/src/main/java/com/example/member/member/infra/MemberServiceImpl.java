package com.example.member.member.infra;

import com.example.member.member.command.application.MemberService;
import com.example.member.member.command.application.request.RegisterRequest;
import com.example.member.member.command.domain.Member;
import com.example.member.member.command.domain.MemberRepository;
import com.example.member.member.command.domain.Role;
import com.example.member.member.query.dto.MemberDto;
import com.example.member.member.query.response.RegisterResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public RegisterResponse createMember(RegisterRequest registerRequest) {

        Member member = Member.of(RegisterRequest.toDto(registerRequest));

        member.grantUserRole();

        memberRepository.findByEmail(member)
                .ifPresent( res -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                });

        return RegisterResponse.of(memberRepository.save(member));
    }
}
