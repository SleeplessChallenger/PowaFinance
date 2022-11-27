package com.powafinance.api;

import com.powafinance.dto.Response;
import com.powafinance.dto.UserDto;
import com.powafinance.persistence.table.User;
import com.powafinance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private static final String USER_CREATION_API = "/add-user";
    private static final String USER_INFO_API = "/get-user-info/{username}";

    private final UserService userService;

    @PostMapping(path = USER_CREATION_API, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> addNewUser(@Valid @RequestBody UserDto userDtoPayload) {
        userService.persistUserData(userDtoPayload);
        return ResponseEntity.ok(
                Response.builder()
                        .responseCode(HttpStatus.OK.value())
                        .message("Successfully added the user")
                        .build()
        );
    }

    @GetMapping(path = USER_INFO_API, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserInfo(@PathVariable @NotBlank String username) {
        final User user = userService.retrieveUserData(username);
        if (user == null) {
            return ResponseEntity.ok(Response.builder()
                    .responseCode(HttpStatus.NO_CONTENT.value())
                    .message(String.format("No user found for username = %s", username))
                    .build()
            );
        }
        return ResponseEntity.ok(user);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> catchErrors(Exception ex) {
        final ErrorMessage error = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }
}
