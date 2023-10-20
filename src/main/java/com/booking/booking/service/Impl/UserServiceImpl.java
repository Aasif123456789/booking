package com.booking.booking.service.Impl;

import com.booking.booking.entities.User;
import com.booking.booking.payload.UserDTO;
import com.booking.booking.repository.BusOperatorRepository;
import com.booking.booking.repository.BusRepository;
import com.booking.booking.repository.UserRepository;
import com.booking.booking.service.UserService;
import com.booking.booking.util.CsvExplore;
import com.booking.booking.util.ExcelExporter;
import com.booking.booking.util.PdfExplorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    private BusRepository busRepository;
    private BusOperatorRepository busOperatorRepository;
    private String uploadDirectory="D:/Bus Ticket Booking/booking/src/main/resources/static/user_profile_image";


@Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, BusRepository busRepository, BusOperatorRepository busOperatorRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.busRepository = busRepository;
        this.busOperatorRepository = busOperatorRepository;


    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = dtoToUser(userDTO);
        //it will save that time when you create
        user.setCreatedAt(new Date());
        //it will save that time when you update
        user.setUpdatedAt(new Date());

        // Encode the password
//if password is null it's also giving that anything
// user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
// If a password is provided, encode and set it
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty())
        {
            //if password is null then its empty in password column
            user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        }
        //this will get image
        MultipartFile profileImage = userDTO.getProfileImage();
        //chack profile image not null & not empty
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName);
        }
        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }
    private String saveProfileImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            String fileExtension =
                    originalFileName.substring(originalFileName.lastIndexOf('.'));
            String baseFileName = originalFileName.substring(0,
                    originalFileName.lastIndexOf('.'));
            String uniqueFileName = baseFileName + "_" +
                    System.currentTimeMillis() + fileExtension;
            Path path = Paths.get(uploadDirectory + uniqueFileName);
            Files.write(path, bytes);
            return uniqueFileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile image", e);
        }
    }
    //DTO to entity
    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
    //Entity to DTO
    private UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setCreatedAt(user.getCreatedAt());

        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }





    @Override
    public Page<UserDTO> getUsers(int page, int size, String sortBy, String
            sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ?

                Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,
                sortBy));
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> userToDto(user));
    }


    @Override
    public InputStreamResource getUserAsExcel() {
        List<User> users = userRepository.findAll();
        try {
            return ExcelExporter.exportUsersToExcel(users);
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate Excel file", e);
        }
    }


    public InputStreamResource getUserAsPdf() throws Exception {
        List<UserDTO> userDTOS = userRepository.findAll().stream().map(e ->
                userToDto(e)).collect(Collectors.toList());
        ByteArrayInputStream pdfInputStream =
                PdfExplorer.exportUsersToPdf(userDTOS);
        return new InputStreamResource(pdfInputStream);
    }

    @Override
    public InputStreamResource getUserCsv() {
        List<UserDTO> userDTOS =
                userRepository.findAll().stream().map(e ->
                        userToDto(e)).collect(Collectors.toList());
        ByteArrayInputStream pdfInputStream=
                CsvExplore.exportUsersToCsv(userDTOS);
        return new InputStreamResource(pdfInputStream);
    }




    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new
                RuntimeException("User not found"));
        userRepository.delete(user);

    }
    @Override
    public  UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new
                RuntimeException("User not found"));
        // Update the fields of the user object
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        // If a new password is provided, encode and set it
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty())

        {

            user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        }
        // If a new profile image is provided, save it and set the filename
        MultipartFile profileImage = userDTO.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName);
        }
        // Set the update time
        user.setUpdatedAt(new Date());
        User updatedUser = userRepository.save(user);
        return userToDto(updatedUser);
    }

    @Override
    public Page<UserDTO> getUsers(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        List<UserDTO> userDTOS =
                usersPage.stream().map(this::userToDto).collect(Collectors.toList());
        return new PageImpl<>(userDTOS,pageable,usersPage.getTotalElements());
    }


}




