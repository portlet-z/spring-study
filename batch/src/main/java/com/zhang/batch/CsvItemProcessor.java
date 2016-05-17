package com.zhang.batch;

import com.zhang.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * @author zhangxinzheng
 * @Date 2016/5/12
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);
        if(item.getNation().equals("汉族")){
            item.setNation("01");
        }else {
            item.setNation("02");
        }
        return item;
    }
}
