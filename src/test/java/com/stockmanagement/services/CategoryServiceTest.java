package com.stockmanagement.services;

import com.stockmanagement.entities.Category;
import com.stockmanagement.exceptions.ResourceNotFoundException;
import com.stockmanagement.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory() {
        Category category = new Category();
        when(categoryRepository.save(category)).thenReturn(category);

        Category savedCategory = categoryService.save(category);

        assertNotNull(savedCategory);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testGetById_CategoryExists() {
        UUID id = UUID.randomUUID();
        Category category = new Category();
        when(categoryRepository.findByUuid(id)).thenReturn(Optional.of(category));

        Category foundCategory = categoryService.getById(id);

        assertNotNull(foundCategory);
        verify(categoryRepository, times(1)).findByUuid(id);
    }

    @Test
    void testGetById_CategoryNotFound() {
        UUID id = UUID.randomUUID();
        when(categoryRepository.findByUuid(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> categoryService.getById(id));
        verify(categoryRepository, times(1)).findByUuid(id);
    }
}
