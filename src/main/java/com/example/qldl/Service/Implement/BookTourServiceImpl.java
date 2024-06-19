package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.BookTourEntity;
import com.example.qldl.Repository.BookTourRepo;
import com.example.qldl.Service.BookTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookTourServiceImpl implements BookTourService {
    @Autowired
    private BookTourRepo bookTourRepo;

    @Override
    public List<BookTourEntity> GetAllInfoBookTour() {
        return bookTourRepo.findAll();
    }

    @Override
    public void doGetDeleteBookTour(Integer bookTourId) {
        bookTourRepo.deleteById(bookTourId);
    }

    @Override
    public BookTourEntity UpdateBookTour(BookTourEntity bookTourEntity){
        return bookTourRepo.saveAndFlush(bookTourEntity);
    }

    @Transactional
    @Override
    public BookTourEntity saveBookTour(BookTourEntity bookTourEntity){
        return bookTourRepo.save(bookTourEntity);
    }

    @Override
    public BookTourEntity doUpload(BookTourEntity bookTourEntity) {
        return null;
    }

    @Override
    public Optional<BookTourEntity> GetBookTourByBookTourId(Integer bookTourId) {
        var result = bookTourRepo.getBookTourEntitiesById(bookTourId);
        return Optional.ofNullable(result);
    }


}
