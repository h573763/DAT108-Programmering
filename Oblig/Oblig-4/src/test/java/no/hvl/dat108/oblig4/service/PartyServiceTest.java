package no.hvl.dat108.oblig4.service;

import no.hvl.dat108.oblig4.dataobjects.Person;
import no.hvl.dat108.oblig4.repositories.PersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PartyServiceTest {

    @InjectMocks
    PartyService ps;

    @Mock
    PersonRepo pr;

    Person atle;
    Person siri;
    Person maren;
    Person unknown;

    @BeforeEach
    void setup(){
         atle = new Person("Alte", "Patle", 41414141, "Male");
         maren = new Person("Maren", "Sør", 45454545, "Female");
         siri = new Person("Siri", "Smidig", 46464646, "Female");
         unknown = new Person();
    }

    @Test
    void sizeTest(){

        when(pr.findAll()).thenReturn(List.of(atle, maren, siri));

        assertEquals(3, ps.findAllParticipants().size());
    }
    @Test
    void findPersonTest(){
        when(pr.findAll()).thenReturn(List.of(atle, siri, maren));

        assertTrue(ps.findAllParticipants().contains(atle));
        assertTrue(ps.findAllParticipants().contains(siri));
        assertTrue(ps.findAllParticipants().contains(maren));
        assertFalse(ps.findAllParticipants().contains(unknown));
    }
}