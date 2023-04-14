package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "carts")
@SequenceGenerator(
        name="CART_SEQ_GEN", //������ ���ʷ����� �̸�
        sequenceName="CART_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
public class Cart {

    @Id
    @GeneratedValue( strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="CART_SEQ_GEN") //�ĺ��� �����⸦ �����س���  USER_SEQ_GEN���� ����        
            
    private int id;

    @Column
    private int memberId;

    @Column
    private int itemId;
}
