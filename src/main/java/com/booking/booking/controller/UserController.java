package com.booking.booking.controller;

import com.booking.booking.payload.UserDTO;
import com.booking.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam(value = "profileImage", required = false)
            MultipartFile profileImage) {


        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setProfileImage(profileImage);
        UserDTO createUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/users/users?page=0&size=7&sortOrder=asc&sortBy=id
//this time available everything asc desc sort by id ,name etc.
    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> getUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder) {
        Page<UserDTO> users = userService.getUsers(page, size, sortBy, sortOrder);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //http://localhost:8080/api/users?page=0&size=2&sort=email,desc
    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<UserDTO> users = userService.getUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

    //http://localhost:8080/api/users/1
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //http://localhost:8080/api/users/download/excel
    @GetMapping("/download/excel")
    public ResponseEntity<InputStreamResource> downloadUsersAsExcel() {
        try {
            InputStreamResource file = userService.getUserAsExcel();
            String fileName="users_"+System.currentTimeMillis()+".xlsx";
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=users.xlsx")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(file);

        } catch (Exception e) {
            return
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



        //http://localhost:8080/api/users/users/pdf
        @GetMapping(value = "/users/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
        public ResponseEntity<InputStreamResource> getUserAsPdf() {
            try {
                InputStreamResource pdf = userService.getUserAsPdf();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment; filename=users.pdf");
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(pdf);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    //http://localhost:8080/api/users/csv
    @GetMapping(value = "/csv",produces = "text/csv")
    public ResponseEntity<InputStreamResource> getUserCsv() {
        InputStreamResource csvStream = userService.getUserCsv();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.csv");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType(" text/csv")).body(csvStream);

}
}



