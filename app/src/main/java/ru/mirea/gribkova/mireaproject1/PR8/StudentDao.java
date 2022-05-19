package ru.mirea.gribkova.mireaproject1.PR8;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Query("SELECT * FROM student WHERE first_name LIKE :first AND " + "last_name LIke :last LiMIT 1")
    Student findByName(String first, String last);

    @Insert
    void insertAll(Student... students);

    @Delete
    void delete(Student student);
}
