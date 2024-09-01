package me.yeong.springbootblog.service;

import lombok.RequiredArgsConstructor;
import me.yeong.springbootblog.domain.User;
import me.yeong.springbootblog.dto.AddUserRequest;
import me.yeong.springbootblog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))  //패스워드 암호화
                .build())
                .getId();
    }
}
