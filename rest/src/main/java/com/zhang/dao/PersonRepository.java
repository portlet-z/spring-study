package com.zhang.dao;

import com.zhang.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author zhangxinzheng
 * @Date 2016/5/11
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(String name);

}
