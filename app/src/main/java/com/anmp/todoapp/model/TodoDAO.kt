package com.anmp.todoapp.model

import androidx.room.*

@Dao
interface TodoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo WHERE is_done = 0 ORDER BY priority DESC")
    suspend fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id")
    fun selectTodo(id:Int): Todo

    @Delete
    fun deleteTodo(todo:Todo)

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
    suspend fun update(title:String, notes:String, priority:Int, id:Int)

    @Query("UPDATE todo SET is_done=:is_done WHERE uuid = :id")
    suspend fun check(is_done:Int, id:Int)




}