package com.artsgard.core.repository;

import com.artsgard.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
