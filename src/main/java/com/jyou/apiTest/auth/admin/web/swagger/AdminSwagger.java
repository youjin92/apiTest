package com.jyou.apiTest.auth.admin.web.swagger;

import com.jyou.apiTest.auth.admin.domain.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Admin API", description = "Admin 테스트 API를 제공합니다.")
public interface AdminSwagger {
    @Operation(summary = "유저 전체 출력")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = Admin.class))),
            @ApiResponse(responseCode = "400", description = "실패 - 요청 파라미터가 유효하지 않음", content = @Content(schema = @Schema(type = "string", example = "fail"))),
    })
    String hello(long a);
}