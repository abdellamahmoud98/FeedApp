package com.bptn.feedapp.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bptn.feedapp.jpa.Feed;
import com.bptn.feedapp.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yaml.snakeyaml.events.Event.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface FeedRepository extends JpaRepository<Feed,Integer>, PagingAndSortingRepository<Feed,Integer> {
	
	Page<Feed> findByUser(User user, Pageable pageable);
	Page<Feed> findByUserNot(User user, Pageable pageable);
	
}
//CRUD:

// spring 

// Hibernate 

