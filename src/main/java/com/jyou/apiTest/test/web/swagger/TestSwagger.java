package com.jyou.apiTest.test.web.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Test API", description = "Hello World 테스트 API를 제공합니다.")
public interface TestSwagger {
    @Operation(summary = "hello world")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(type = "string"))),
        @ApiResponse(responseCode = "400", description = "실패 - 요청 파라미터가 유효하지 않음", content = @Content(schema = @Schema(type = "string", example = "fail"))),
    })
    String hello();
}
