package br.edu.ifpb.dac.junior.utils;

import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.business.dto.LocalDto;
import br.edu.ifpb.dac.junior.model.entity.Event;
import br.edu.ifpb.dac.junior.model.entity.Local;

import java.util.ArrayList;

public class Convert {

    public static Event dtoToEvent(EventDto eventDto){
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setDate(eventDto.getDate());
        event.setTime(eventDto.getTime());

        Local local = new Local();

        local.setStreet(eventDto.getStreet());
        local.setNumber(eventDto.getNumber());
        local.setCity(eventDto.getCity());
        local.setUf(eventDto.getUf());

        event.getLocals().add(local);
        return event;
    }

    public static EventDto EventToDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setDate(event.getDate());
        eventDto.setTime(event.getTime());

        eventDto.setIdLocal(event.getLocals().get(0).getId());
        eventDto.setStreet(event.getLocals().get(0).getStreet());
        eventDto.setNumber(event.getLocals().get(0).getNumber());
        eventDto.setCity(event.getLocals().get(0).getCity());
        eventDto.setUf(event.getLocals().get(0).getUf());


        return eventDto;
    }

    public static Local dtoToLocal(LocalDto localDto){
        Local local = new Local();
        local.setStreet(localDto.getStreet());
        local.setNumber(localDto.getNumber());
        local.setCity(localDto.getCity());
        local.setUf(localDto.getUf());
        return local;
    }

    public static LocalDto localToDto(Local local){
        LocalDto localDto = new LocalDto();
        localDto.setId(local.getId());
        localDto.setStreet(local.getStreet());
        localDto.setNumber(local.getNumber());
        localDto.setCity(local.getCity());
        localDto.setUf(local.getUf());
        return localDto;
    }
}
