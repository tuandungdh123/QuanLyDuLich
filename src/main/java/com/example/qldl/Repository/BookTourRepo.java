package com.example.qldl.Repository;

import com.example.qldl.Entity.BookTourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookTourRepo extends JpaRepository<BookTourEntity,Integer> {
    @Query(value = "SELECT Book_Tour.Book_Tour_Id,Book_Tour.Tour_Id,Book_Tour.Name_User, Book_Tour.Phone, \n" +
            "Book_Tour.Email, Book_Tour.Address, Book_Tour.Description, Book_Tour.Number_adults, Book_Tour.Number_Children\n" +
            "From Book_Tour inner join Tour on Book_Tour.Tour_Id = Tour.Tour_Id \n" +
            "WHERE Book_Tour.Book_Tour_Id = ?", nativeQuery = true)
    BookTourEntity getBookTourEntitiesById(Integer bookTourId);


}

