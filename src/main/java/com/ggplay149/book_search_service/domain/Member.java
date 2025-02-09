package com.ggplay149.book_search_service.domain;

import lombok.Data;

@Data
public class Member {

    private String id;
    private int password;
    private String city;
    private String sex;
    private String[] hobby;
    private String greetings;

}
