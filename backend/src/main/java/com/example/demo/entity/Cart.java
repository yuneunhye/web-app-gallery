package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "carts")
@SequenceGenerator(
        name="CART_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="CART_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class Cart {

    @Id
    @GeneratedValue( strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="CART_SEQ_GEN") //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
            
    private int id;

    @Column
    private int memberId;

    @Column
    private int itemId;
}
