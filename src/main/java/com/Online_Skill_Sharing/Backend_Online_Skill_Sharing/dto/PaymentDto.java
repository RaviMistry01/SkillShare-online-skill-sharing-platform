package com.Online_Skill_Sharing.Backend_Online_Skill_Sharing.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDto {
    private int userId;
    private int courseId;
    private double amount;
    private String paymentMethod;
    private Date paymentDate;
}
