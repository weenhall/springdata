package com.imooc.repository;


import com.imooc.domain.Employee;
import com.imooc.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingAndSortingRepositoryTest {


    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testPage() {
        //page;index从0开始
        Pageable pageable=new PageRequest(0,5);
        Page<Employee> employeePage=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("page总页数"+ employeePage.getTotalPages());
        System.out.println("page总记录数"+ employeePage.getTotalElements());
        System.out.println("page当前页"+ employeePage.getNumber()+1);
        System.out.println("page当前页集合"+ employeePage.getContent());
        System.out.println("page当前页记录数"+ employeePage.getNumberOfElements());
    }

    @Test
    public void testSort() {
        Sort.Order order=new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort=new Sort(order);
        //page;index从0开始
        Pageable pageable=new PageRequest(0,5,sort);
        Page<Employee> employeePage=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("page总页数"+ employeePage.getTotalPages());
        System.out.println("page总记录数"+ employeePage.getTotalElements());
        System.out.println("page当前页"+ employeePage.getNumber()+1);
        System.out.println("page当前页集合"+ employeePage.getContent());
        System.out.println("page当前页记录数"+ employeePage.getNumberOfElements());
    }


}
