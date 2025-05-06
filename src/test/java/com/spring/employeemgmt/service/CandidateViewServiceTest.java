package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.CandidateView;
import com.spring.employeemgmt.repository.CandidateViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CandidateViewServiceTest {

    private CandidateViewRepository viewRepository;
    private CandidateViewService service;

    @BeforeEach
    void setUp() {
        viewRepository = mock(CandidateViewRepository.class);
        service = new CandidateViewService();
        service.viewRepository = viewRepository; // Manual injection
    }

    @Test
    void testSaveView() {
        CandidateView inputView = CandidateView.builder()
                .viewName("Sample View")
                .selectedColumns(Arrays.asList("name", "email"))
                .build();

        CandidateView savedView = CandidateView.builder()
                .id(1L)
                .viewName("Sample View")
                .selectedColumns(inputView.getSelectedColumns())
                .createdBy("testUser")
                .build();

        when(viewRepository.save(any(CandidateView.class))).thenReturn(savedView);

        CandidateView result = service.saveView(inputView, "testUser");

        assertNotNull(result);
        assertEquals("Sample View", result.getViewName());
        assertEquals("testUser", result.getCreatedBy());
        assertEquals(2, result.getSelectedColumns().size());

        verify(viewRepository, times(1)).save(any(CandidateView.class));
    }

    @Test
    void testGetAllViews() {
        List<CandidateView> mockViews = Arrays.asList(
                CandidateView.builder().id(1L).viewName("View 1").build(),
                CandidateView.builder().id(2L).viewName("View 2").build()
        );

        when(viewRepository.findAll()).thenReturn(mockViews);

        List<CandidateView> result = service.getAllViews();

        assertEquals(2, result.size());
        assertEquals("View 1", result.get(0).getViewName());
        assertEquals("View 2", result.get(1).getViewName());

        verify(viewRepository).findAll();
    }

    @Test
    void testGetViewById() {
        CandidateView view = CandidateView.builder()
                .id(1L)
                .viewName("View 1")
                .build();

        when(viewRepository.findById(1L)).thenReturn(Optional.of(view));

        CandidateView result = service.getViewById(1L);

        assertNotNull(result);
        assertEquals("View 1", result.getViewName());
        verify(viewRepository).findById(1L);
    }

    @Test
    void testDeleteView() {
        doNothing().when(viewRepository).deleteById(1L);

        service.deleteView(1L);

        verify(viewRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetViewsByUser() {
        List<CandidateView> views = Arrays.asList(
                CandidateView.builder()
                        .id(1L)
                        .viewName("User View")
                        .createdBy("user123")
                        .build()
        );

        when(viewRepository.findByCreatedBy("user123")).thenReturn(views);

        List<CandidateView> result = service.getViewsByUser("user123");

        assertEquals(1, result.size());
        assertEquals("User View", result.get(0).getViewName());
        verify(viewRepository).findByCreatedBy("user123");
    }
}

