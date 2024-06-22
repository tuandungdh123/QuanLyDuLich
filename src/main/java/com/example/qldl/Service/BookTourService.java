package com.example.qldl.Service;

import com.example.qldl.Entity.BookTourEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookTourService {
    List<BookTourEntity> GetAllInfoBookTour();

    void doGetDeleteBookTour(Integer tourID);

    BookTourEntity UpdateBookTour(BookTourEntity bookTourEntity);


    BookTourEntity saveBookTour(BookTourEntity bookTourEntity);

    BookTourEntity doUpload(BookTourEntity bookTourEntity);

    Optional<BookTourEntity> GetBookTourByBookTourId(Integer bookTourId);

    List<BookTourEntity> GetBookTourByStatusID(Integer status_Id);
}