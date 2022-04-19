package ru.parsing.coursecurrency.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.parsing.coursecurrency.models.domain.Course;
import ru.parsing.coursecurrency.services.ecb.CourseEsbApi;

import java.util.List;

@RestController
@RequestMapping("/ecb")
@RequiredArgsConstructor
@Slf4j
public class CourseEcbController {

    @Autowired
    private final CourseEsbApi courseEsbApi;

    @Operation(summary = "Gets course ECB", tags = "Course currency")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the course currency in database",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Course.class)))
                    }),
            @ApiResponse(responseCode = "400", description = "No description"),
            @ApiResponse(responseCode = "404", description = "No description"),
            @ApiResponse(responseCode = "405", description = "No description")
    })
    @GetMapping("/")
    public List<Course> getCourseEcb() {
        return courseEsbApi.getCourseApi();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "MAMA YA SLOMALSYA";
    }
}
