package com.example.member.member.query.dto;

import com.example.member.member.command.domain.Member;
import com.example.member.member.command.domain.Role;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private Role role;

    public static MemberDto of(
            Long id,
            String email,
            String nickname,
            String password,
            Role role
    ) {
        return MemberDto.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .role(role)
                .build();
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .password(member.getPassword())
                .role(member.getRole())
                .build();
    }

}
