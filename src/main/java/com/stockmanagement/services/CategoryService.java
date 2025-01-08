package com.stockmanagement.services;

import com.stockmanagement.entities.Category;
import com.stockmanagement.exceptions.ResourceNotFoundException;
import com.stockmanagement.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category save(Category category) {
        try {
            categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            log.error("Data integrity violation while saving category", e);
            throw new RuntimeException("Data integrity violation while saving category");
        } catch (DataAccessException e) {
            log.error("Data access error while saving category", e);
            throw new RuntimeException("Data access error while saving category");
        } catch (Exception e) {
            log.error("Error while saving category", e);
            throw new RuntimeException("Error while saving category");
        }
        return category;
    }

    public Category getById(UUID id) {
        return categoryRepository.findByUuid(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}