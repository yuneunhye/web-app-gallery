package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
@SequenceGenerator(
        name="ORDER_SEQ_GEN", //������ ���ʷ����� �̸�
        sequenceName="ORDER_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
public class Order {

    @Id
    @GeneratedValue( strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
    generator="ORDER_SEQ_GEN") //�ĺ��� �����⸦ �����س���  USER_SEQ_GEN���� ����        
    
    private int id;

    @Column
    private int memberId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private String payment;

    @Column(length = 16)
    private String cardNumber;

    @Column(length = 500, nullable = false)
    private String items;
}
