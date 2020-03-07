package com.wordata.demo.service;

import com.wordata.demo.domain.User;
import com.wordata.demo.repository.UserRepository;
import com.wordata.demo.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(String loginId, String password) {
        User user = userRepository.findOneByLoginId(loginId);
        if (user == null) {
            return null;
        }
        String pw = EncryptionUtils.encryptSHA256(password);
        //받아온 password를 암호화 한다.
        if (!user.getPassword().equals(pw)) {
            return null;
            // 받아온 암호화 pw와 DB에 password를 비교하여 false면 null return
        }
        return user;
    }

    public void signup(User user) {
        //db에 user 저장
        String pw = EncryptionUtils.encryptSHA256(user.getPassword());
        user.setPassword(pw);
        userRepository.save(user);
    }

}
