package com.example.midscheduleapp.user.Service;

import com.example.midscheduleapp.user.Dto.*;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request){
        User newUser = new User(request.getUsername(), request.getEmail());
        User user  = userRepository.save(newUser);
        return new CreateUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    // 유저 전체 조회
    @Transactional(readOnly = true)
    public List<GetUserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();
        for(User user : users) {
            GetUserResponse dto = new GetUserResponse(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail()
            );
            dtos.add(dto);
        }
        return dtos;
    }



    // 유저 단건 조회
    @Transactional(readOnly = true)
    public GetUserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () ->new IllegalStateException("해당 유저가 없습니다")
        );
        return new GetUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    // 유저 업데이트
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저가 없습니다")
        );
        user.update(request.getUsername(), request.getEmail());
        return new UpdateUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    // 유저 삭제
    @Transactional
    public void delete(Long userId) {
        boolean existence = userRepository.existsById(userId);
        if(!existence) {
            throw new IllegalStateException("해당 유저가 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
