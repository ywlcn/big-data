package org.rgs.ignite.mybatis.controller;

import org.apache.ignite.Ignite;
import org.rgs.domain.Student;
import org.rgs.ignite.mybatis.service.StudentService;
import org.rgs.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/mybatis")
public class IgniteMybatisController {

    @Autowired
    private StudentService studentService;


//    @Autowired
    private Ignite ignite;

    @GetMapping()
    public String init() {
        long start = System.currentTimeMillis();
        List<Student> students = studentService.findAllStudents();
        String result = JsonUtils.toJson(students);
        System.out.println(result);
        return result;
    }

    @GetMapping("/error")
    public String doError() {

        Student student = new Student();
        student.setName("setName111");
        student.setEmail("setEmail2222");
        student.setStudId(1);

        studentService.doTransactionalError(student);

        String result = JsonUtils.toJson(student);
        System.out.println(result);
        return result;
    }

//
//    @GetMapping("/findStudentsById")
//    public String findStudentsById(int studentId) {
//        long start = System.currentTimeMillis();
//        Student student = mapper.findStudentsById(studentId);
//        System.out.printf("/findStudentsById 耗时 [%s]ms.\n", System.currentTimeMillis() - start);
//        String result = JsonUtils.toJson(student);
//        System.out.println(result);
//        return result;
//    }
//
//    @GetMapping("/findGradeByName")
//    public double findGradeByName(String name) {
//       double grade = mapper.findGradeByName(name);
//       return grade;
//    }
//
//    /**
//     * api查询性能对比测试
//     */
//    @GetMapping("/cpFindStudentsById")
//    public String cpFindStudentsById(String studentId) {
//        IgniteCache<String, Student> cache = ignite.cache("studentCache");
//        SqlFieldsQuery sfq = new SqlFieldsQuery("select * from student where studid=?").setArgs(6).setReplicatedOnly(true);
//        long start = System.currentTimeMillis();
//        FieldsQueryCursor<List<?>> qc = cache.query(sfq);
//        System.out.printf("/cpFindStudentsById 耗时 [%s]ms.\n", System.currentTimeMillis() - start);
//        List<Map<?, ?>> maps = qc.getAll().stream().map(x -> IntStream.range(0, x.size()).boxed().collect(Collectors.toMap(i -> qc.getFieldName(i), i -> x.get(i)))).collect(Collectors.toList());
//        String result = JsonUtils.toJson(maps);
//        System.out.println(result);
//        return result;
//    }

}
