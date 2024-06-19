package com.example.qldl.DTO;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ThongKeDTO {
    private long soLuongRole1;
    private long soLuongRole2;

    public ThongKeDTO(long soluongRole1, long soluongRole2) {
        this.soLuongRole1 = soluongRole1;
        this.soLuongRole2 = soluongRole2;


    }
}