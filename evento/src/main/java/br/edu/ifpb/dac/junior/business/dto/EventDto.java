package br.edu.ifpb.dac.junior.business.dto;

import br.edu.ifpb.dac.junior.model.entity.Local;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private String date;
    private String time;

    private List<Local> locals;

    public EventDto(String title, String description, String date, String time) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

}
