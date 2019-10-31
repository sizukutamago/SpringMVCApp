package com.sample.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyMemoDataRepository extends JpaRepository<MyMemoData, Long> {
}
