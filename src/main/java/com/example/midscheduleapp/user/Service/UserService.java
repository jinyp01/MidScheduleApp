package com.example.midscheduleapp.user.Service;

import com.example.midscheduleapp.schedule.Dto.CreateScheduleResponse;
import com.example.midscheduleapp.user.Dto.CreateUserRequest;
import com.example.midscheduleapp.user.Dto.CreateUserResponse;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
