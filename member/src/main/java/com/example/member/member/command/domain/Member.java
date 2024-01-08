package com.example.member.member.command.domain;

import com.example.member.common.command.domain.BaseTimeEntity;
import com.example.member.member.query.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member of(MemberDto memberDto) {
        return Member.builder()
                .id(memberDto.getId())
                .email(memberDto.getEmail())
                .nickname(memberDto.getNickname())
                .password(memberDto.getPassword())
                .role(memberDto.getRole())
                .build();
    }

    public Member grantUserRole() {
        this.role = Role.USER;
        return this;
    }
}
