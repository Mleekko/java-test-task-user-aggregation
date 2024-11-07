package com.task.user.aggregation.rest;


import com.task.user.aggregation.dto.User;
import com.task.user.aggregation.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))
            })
    })
    @Operation(summary = "Find Users", description = "Find aggregated users from all the databases.")
    @GetMapping("/users")
    public List<User> findUsers() {
        return userService.getUsers();
    }

}
