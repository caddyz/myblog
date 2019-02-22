package com.kaiser.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToBrowserUser {
    private String token;
    private Long userId;
    private String userName;
}
