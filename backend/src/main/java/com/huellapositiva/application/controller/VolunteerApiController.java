package com.huellapositiva.application.controller;

import com.huellapositiva.application.dto.RegisterVolunteerRequestDto;
import com.huellapositiva.application.exception.PasswordNotAllowed;
import com.huellapositiva.domain.actions.RegisterVolunteerAction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/volunteers")
public class VolunteerApiController {
    @Autowired
    private RegisterVolunteerAction registerVolunteerAction;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerVolunteer(@Validated @RequestBody RegisterVolunteerRequestDto dto) {
        try {
            registerVolunteerAction.execute(dto);
        } catch (PasswordNotAllowed pna) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't meet minimum length", pna);
        }
    }
}
