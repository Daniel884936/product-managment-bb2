package com.productmanagment.productmanagment.services;

import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.dtos.UserDTO;
import com.productmanagment.productmanagment.exception.ConflictException;
import com.productmanagment.productmanagment.exception.NotFoundException;
import com.productmanagment.productmanagment.models.User;
import com.productmanagment.productmanagment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO add(UserDTO userDTO) {
        User UserFromDb = userRepository.findUserByUserName(userDTO.getUsername());
        if(UserFromDb != null)
            throw new ConflictException("User already exist");
        User user = HibernateDTOAssemblerFactory.DEFAULT.getUserAssembler().Dto2Pojo(userDTO);
        user =  userRepository.save(user);
       return HibernateDTOAssemblerFactory.DEFAULT.getUserAssembler().pojo2Dto( user);
    }

    @Override
    public void delete(Long id) {
        User userFromDbTracking = userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found"));
        userRepository.delete(userFromDbTracking);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found"));
        return HibernateDTOAssemblerFactory.DEFAULT.getUserAssembler().pojo2Dto( user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(user ->
             HibernateDTOAssemblerFactory.DEFAULT.getUserAssembler().pojo2Dto(user)
        ).collect(Collectors.toList());
    }
}
