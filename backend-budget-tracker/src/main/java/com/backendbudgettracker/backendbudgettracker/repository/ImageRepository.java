package com.backendbudgettracker.backendbudgettracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendbudgettracker.backendbudgettracker.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByType(Image.Type type);

}