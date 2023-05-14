//package com.example.databaseteamproject.service;
//
//
//import com.example.databaseteamproject.entity.MainUser;
//import com.example.databaseteamproject.payload.ApiResponse;
//import com.example.databaseteamproject.payload.UserDto;
//import com.example.databaseteamproject.repository.MainUserRepository;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class MainUserService {
//
//    @Autowired
//    MainUserRepository userRepository;
//
//    public List<MainUser> getAll(){
//        return userRepository.findAll();
//
//    }
//
//    public MainUser getById(String id){
//        Optional<MainUser> byId = userRepository.findById(id);
//        return byId.orElse(null);
//    }
//
//    public ApiResponse addQA(@Valid UserDto userDto){
//        MainUser mainUser = new MainUser();
//        mainUser.setUsername(userDto.getUsername());
//        mainUser.setPassword(userDto.getPassword());
//        mainUser.setFirstName(userDto.getFirstName());
//        mainUser.setLastName(userDto.getLastName());
//        mainUser.setAddress(userDto.getAddress());
//        mainUser.setPhoneNumber(userDto.getPhoneNumber());
//        MainUser save = userRepository.save(mainUser);
//
//        return new ApiResponse("saved with id: "+save.getUsername(), true);
//    }
//
//    public ApiResponse deleteQA(String id){
//
//        Optional<MainUser> byId = userRepository.findById(id);
//        if (byId.isEmpty()) {
//            return new ApiResponse("no element with such id", false);
//        }
//
//        userRepository.deleteById(id);
//        return new ApiResponse("deleted", true);
//
//    }
//
//}
