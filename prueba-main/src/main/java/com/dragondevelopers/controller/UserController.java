package com.dragondevelopers.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dragondevelopers.entity.User;
import com.dragondevelopers.service.UserService;
import com.dto.MessageDTO;

@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*")
@Log4j2
@RestController
@ResponseBody
@RequestMapping("users")
public class UserController {
    
    private final UserService userService;

    @PostMapping("/save")
	public ResponseEntity<MessageDTO> saveFunction(@RequestBody User u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(u));
	}

}
