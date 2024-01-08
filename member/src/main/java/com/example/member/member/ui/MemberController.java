package com.example.member.member.ui;

import com.example.member.common.command.application.CustomResponseUtils;
import com.example.member.common.command.application.CustomResponseUtils.CustomResponse;
import com.example.member.member.command.application.MemberService;
import com.example.member.member.command.application.request.RegisterRequest;
import com.example.member.member.query.response.RegisterResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.member.common.command.application.CustomResponseUtils.success;

@Tag(name = "Member", description = "멤버 관리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "이메일 회원가입 API", description = "이메일로 회원가입을 진행합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "회원가입 실패"),
            @ApiResponse(responseCode = "409", description = "이미 존재하는 이메일"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @PostMapping("/register")
    public ResponseEntity<CustomResponse<RegisterResponse>> createMember(
            @Validated @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(success(memberService.createMember(registerRequest)));
    }
}
