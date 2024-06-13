package com.example.qldl.Repository;

import com.example.qldl.Entity.TourE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepo extends JpaRepository<TourE, Integer> {
    @Query(value = "SELECT Tour.Tour_ID, Tour.Tour_Name, Tour.Images, Tour.Type_Id, Tour.Duration, Tour.Time_Start, Tour.Transport, Tour.Starting_Place, Tour.Price, Tour.Decription, Tour.Available, Tour.Experience, Type_Tour.Type_Id AS Expr1, Type_Tour.Type_Name FROM Tour INNER JOIN Type_Tour ON Tour.Type_Id = Type_Tour.Type_Id WHERE Tour.Type_Id = ?", nativeQuery = true)
    List<TourE> getTourEByTypeId(Integer type_Id);


    TourE getTourEByTourID(Integer tourID);
}
