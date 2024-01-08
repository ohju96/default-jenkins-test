package com.example.member.member.command.application;

import com.example.member.member.command.application.request.RegisterRequest;
import com.example.member.member.query.response.RegisterResponse;

public interface MemberService {

    RegisterResponse createMember(RegisterRequest registerRequest);

}
