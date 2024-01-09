package com.example.member.member.infra;

import com.example.member.member.command.application.request.RegisterRequest;
import com.example.member.member.command.domain.Role;
import com.example.member.member.query.response.RegisterResponse;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입 테스트")
    void createMember() {
        // given
        RegisterRequest registerRequest = new RegisterRequest(
                "test@test.com",
                "Test-Member",
                "12345678"
        );

        // when
        RegisterResponse member = memberService.createMember(registerRequest);

        // then
        assertThat(member.email()).isEqualTo(registerRequest.email());
        assertThat(member.nickname()).isEqualTo(registerRequest.nickname());
        assertThat(member.role()).isEqualTo(Role.USER);
    }

    @Test
    @DisplayName("중복 회원가입 테스트")
    void duplicateMember() {
        // given
        RegisterRequest registerRequest1 = new RegisterRequest(
                "test@test.com",
                "Test-Member",
                "12345678"
        );

        RegisterRequest registerRequest2 = new RegisterRequest(
                "test@test.com",
                "Test-Member",
                "12345678"
        );

        // when
        memberService.createMember(registerRequest1);

        // then
        assertThatThrownBy(() -> memberService.createMember(registerRequest2))
                .hasMessage("이미 존재하는 회원입니다.");
    }

}