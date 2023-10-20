package com.booking.booking.service;

import com.booking.booking.entities.Bus;
import com.booking.booking.payload.UserDTO;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public UserDTO createUser(UserDTO userDTO);
   // public Page<UserDTO> getUsers(int pageNumber, int pageSize);

    public void deleteUser(Long userId);

    public  UserDTO updateUser(Long userId, UserDTO userDTO);

    Page<UserDTO> getUsers(Pageable pageable);

    public Page<UserDTO> getUsers(int page, int size, String sortBy, String sortOrder);

   // Page<UserDTO> getUsers(int pageNumber, int pageSize);

    InputStreamResource getUserAsExcel();

    InputStreamResource getUserAsPdf() throws Exception;

    InputStreamResource getUserCsv();

}

