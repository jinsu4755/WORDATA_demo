package com.wordata.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    /*Entity 객체는 db layer와 데이터를 주고 받을 때 사용
    * Entity class 에는 setter를 최소한으로 사용
    * 명확한 의미를 가진 함수를 정의할 수 있으면 setter를 사용하지 않고 함수를 정의하여
    * 값을 세팅한다.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loginId;
    private String password;
    private String name;
    private String userType;
    private String department;

    @Builder
    public UserEntity(int id, String loginId, String password, String name, String userType, String department) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.department = department;
    }



}
