package com.wordata.demo.dto;

import com.wordata.demo.domain.UserEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
    /*DTO 객체는 view layer와 데이터를 주고받을 때 사용*/
    private int id;

    @NotBlank(message = "ID를 입력해주세요")
    private String loginId;

    @NotBlank(message = "PW를 입력해주세요")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    private String userType;

    @NotBlank(message = "학과를 정확하게 골라주세요, ----와 같은 부분은 입력 할 수 없습니다.")
    private String department;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .name(name)
                .userType(userType)
                .department(department)
                .build();
    }

    @Builder
    public UserDTO(int id, String loginId, String password, String name, String userType, String department) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.department = department;
    }

}
