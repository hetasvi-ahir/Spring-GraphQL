
package com.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.query.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
