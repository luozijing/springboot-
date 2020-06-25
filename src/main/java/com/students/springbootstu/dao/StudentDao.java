package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbStudent;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface StudentDao {

    /**
     * 返回所有学生
     */
    @Select("SELECT * FORM TB_STUDENT")
    List<TbStudent> findAllStudent();

    /**
     *根据ID删除某个学生
     */
    @Delete("DELETE FROM tb_student WHERE stuId = #{stuId}")
    void deleteStu(@Param("stuId") int stuId);

    /**
     *根据ID更新信息
     */
    @Update("UPDATE tb_student SET stuName = #{stuName}, stuSex = #{stuSex}, stuBirth = #{stuBirth}, stuTel = #{stuTel}, stuAdr = #{stuAdr}, stuPhoto = #{stuPhoto} WHERE stuId = #{stuId}")
    void updateStu(@Param("stuName") String stuName, @Param("stuSex") byte stuSex, @Param("stuBirth") Date stuBirth, @Param("stuTel") String stuTel, @Param("stuAdr") String stuAdr, @Param("stuPhoto") byte[] stuPhoto);

    /**
     * 插入学生信息
     */
    @Insert("INSERT INTO tb_student (stuId, stuName, stuSex, stuBirth, stuTel, stuAdr, stuPhoto ) VALUES(#{stuId}, #{stuName}, #{stuSex}, #{stuBirth}, #{stuTel}, #{stuAdr}, #{stuPhoto})")
    void insertStu(@Param("stuId") String stuId, @Param("stuName") String stuName, @Param("stuSex") byte stuSex, @Param("stuBirth") Date stuBirth, @Param("stuTel") String stuTel, @Param("stuAdr") String stuAdr, @Param("stuPhoto") byte[] stuPhoto);
}
