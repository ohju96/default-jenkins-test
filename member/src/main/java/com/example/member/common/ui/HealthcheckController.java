package com.example.member.common.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Utils", description = "헬스 체크 API")
@RestController
@RequestMapping("/healthcheck")
public class HealthcheckController {

    @Operation(summary = "헬스 체크 API", description = "서버 정상 동작을 체크합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "서버 정상 동작"),
    })
    @GetMapping("")
    public String healthcheck() {
        return "OK";
    }
}
