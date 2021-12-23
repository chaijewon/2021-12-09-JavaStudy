package com.sist.food;

import lombok.Getter;
import lombok.Setter;

// 캡슐화 => 변수(private):은닉화 , 접근 : 메소드를 통해서 접근 (public)
@Getter
@Setter
public class Category {
   private int no;
   private String title;
   private String subject;
   
}
