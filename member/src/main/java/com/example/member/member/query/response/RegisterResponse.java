package com.example.member.member.query.response;

import com.example.member.member.command.domain.Member;
import com.example.member.member.command.domain.Role;
import lombok.Builder;

@Builder
public record RegisterResponse(
        String nickname,
        String email,
        Role role
) {

    public static RegisterResponse of(Member member) {
        return RegisterResponse.builder()
                .nickname(member.getNickname())
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }
}
