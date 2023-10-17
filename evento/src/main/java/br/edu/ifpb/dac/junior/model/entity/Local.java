package br.edu.ifpb.dac.junior.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "locals")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String city;
    private String uf;

    @ManyToMany(mappedBy = "locals", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Event> events = new ArrayList<>();


    public Local(String street, String number, String city, String uf) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.uf = uf;
    }


}
