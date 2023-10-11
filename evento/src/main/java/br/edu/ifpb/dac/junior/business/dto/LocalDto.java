package br.edu.ifpb.dac.junior.business.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocalDto {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String uf;

    public LocalDto(String street, String number, String city, String uf) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.uf = uf;
    }

}
