package com.example.midscheduleapp.user.Service;

import com.example.midscheduleapp.config.PasswordEncoder;
import com.example.midscheduleapp.user.Dto.*;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 유저 생성 (즉 회원가입) 기능 추가
    @Transactional
    public CreateUserResponse create(CreateUserRequest request){
        boolean exist = userRepository.existsByEmail(request.getEmail());
        if(exist) {
            throw new IllegalStateException("이미 존재하는 유저입니다");
        }


        User newUser = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail()
        );

        User user  = userRepository.save(newUser);
        return new CreateUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Transactional
    public LoginResponse login(LoginRequest request){
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("이메일 또는 비밀번호가 잘못됐습니다.")
        );
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalStateException("이메일 또는 비밀번호가 잘못됐습니다.");
        }
        return new LoginResponse(
                user.getUserId(),
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
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

//    @Transactional(readOnly = true)
//    public Page<User> getPageUsers(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by("updatedAt").descending());
//        return userRepository.findAll(pageable);
//    }

    // 유저 단건 조회
    @Transactional(readOnly = true)
    public GetUserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () ->new IllegalStateException("해당 유저가 없습니다")
        );
        return new GetUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    // 유저 업데이트
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저가 없습니다")
        );
        user.update(request.getUsername());
        return new UpdateUserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
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
