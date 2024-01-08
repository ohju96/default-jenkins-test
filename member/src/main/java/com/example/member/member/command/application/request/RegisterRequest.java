package com.example.member.member.command.application.request;

import com.example.member.member.query.dto.MemberDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotNull
        @Schema(title = "이메일", description = "이메일 가입자를 위한 컬럼", example = "test@test.com")
        String email,

        @NotNull
        @Schema(description = "멤버의 닉네임", example = "Test-Member")
        String nickname,

        @NotNull
        @Schema(description = "멤버의 비밀번호", example = "12345678")
        String password
) {
        public static MemberDto toDto(RegisterRequest registerRequest) {
                return MemberDto.builder()
                        .email(registerRequest.email())
                        .nickname(registerRequest.nickname())
                        .password(registerRequest.password())
                        .build();
        }
}
