package com.example.qldl.DTO;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ThongKeDTO {
    private long soLuongRole1;
    private long soLuongRole2;
    private long tour1;
    private long tour2;
    private long tour3;
    private long tour4;
    private long tour5;


    public ThongKeDTO(long soluongRole1, long soluongRole2) {
        this.soLuongRole1 = soluongRole1;
        this.soLuongRole2 = soluongRole2;
    }
    public ThongKeDTO(long tour1, long tour2, long tour3, long tour4, long tour5) {
        this.tour1 = tour1;
        this.tour2 = tour2;
        this.tour3 = tour3;
        this.tour4 = tour4;
        this.tour5 = tour5;
    }
}
