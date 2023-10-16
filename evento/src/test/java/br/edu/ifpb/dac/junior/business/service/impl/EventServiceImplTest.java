package br.edu.ifpb.dac.junior.business.service.impl;


import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.model.entity.Event;
import br.edu.ifpb.dac.junior.model.repository.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;




    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
//        eventDto = new EventDto();
//
//        eventDto.setTitle("Interclasse IFPB");
//        eventDto.setDescription("Evento esportivo do campus");
//        eventDto.setTime("09:00");
//        eventDto.setDate("30/09/2023");
//        eventDto.setLocals(null);
//        EventDto eventoSalvo = eventService.save(eventDto);
//        //assertNotNull(eventoSalvo);
//        assertEquals("Interclasse IFPB", eventoSalvo.getTitle());
//        assertEquals("Evento esportivo do campus", eventoSalvo.getDescription());
//        assertEquals("09:00", eventoSalvo.getTime());
//        assertEquals("30/09/2023", eventoSalvo.getDate());
//        assertNull(eventoSalvo.getLocals());



        Event event1 = new Event("Interclasse IFPB", "Evento esportivo do campus", "30/09/2023", "09:00");
        event1.setId(1L);
        //when(eventRepository.save(event1)).thenReturn(event1);
        EventDto event2 = new EventDto("Interclasse IFPB", "Evento esportivo do campus", "30/09/2023", "09:00");
        EventDto productSaved = eventService.save(event2);

        assertNotNull(productSaved);
        assertEquals(event1.getTitle(), productSaved.getTitle());
        assertEquals(event1.getDescription(), productSaved.getDescription());
        assertEquals(event1.getDescription(), productSaved.getDescription());
        verify(eventRepository, times(1)).save(event1);
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAllEvents() {
    }

    @Test
    void delete() {
    }
}