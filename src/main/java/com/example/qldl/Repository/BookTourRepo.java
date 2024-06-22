package com.example.qldl.Repository;

import com.example.qldl.Entity.BookTourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookTourRepo extends JpaRepository<BookTourEntity,Integer> {
    @Query(value = "SELECT Book_Tour.Book_Tour_Id,Book_Tour.Tour_Id,Book_Tour.Name_User, Book_Tour.Phone, \n" +
            "Book_Tour.Email, Book_Tour.Address, Book_Tour.Description, Book_Tour.Number_adults, Book_Tour.Number_Childrens, Book_Tour.number_tre_nho, Book_Tour.Price, Book_Tour.Date_Booked,Book_Tour.Status_ID\n" +
            "From Book_Tour inner join Tour on Book_Tour.Tour_Id = Tour.Tour_Id \n" +
            "WHERE Book_Tour.Book_Tour_Id = ?", nativeQuery = true)
    BookTourEntity getBookTourEntitiesById(Integer bookTourId);

    @Query(value = "SELECT Book_Tour.Book_Tour_Id, Book_Tour.Tour_Id, Book_Tour.Name_User, Book_Tour.Phone, Book_Tour.Email, Book_Tour.Address, Book_Tour.Description, Book_Tour.Number_adults, Book_Tour.Number_Childrens, Book_Tour.number_tre_nho, Book_Tour.Price, Book_Tour.Date_Booked, Book_Tour.Status_ID, Status_Tour.Type_Status AS Expr1, Status_Tour.type_Status FROM Book_Tour INNER JOIN Status_Tour ON Book_Tour.Status_ID = Status_Tour.Status_ID WHERE Book_Tour.Status_ID = ?;", nativeQuery = true)
    List<BookTourEntity> getBookTourEntitiesByStatusId(Integer bookTourId);


}