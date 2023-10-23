package br.edu.ifpb.dac.junior.utils;

import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.business.dto.LocalDto;
import br.edu.ifpb.dac.junior.business.dto.UserDto;
import br.edu.ifpb.dac.junior.model.entity.Event;
import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.model.entity.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static UserModel dtoToUser(UserDto dto){
        UserModel entity = new UserModel();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public static UserDto userToDto(UserModel entity){
        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());

        dto.setUserRole(entity);



        return dto;
    }


}
