package com.newjob.consultant.service;

import com.newjob.consultant.entity.career.CareerTestResult;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataMapper {

    public Context setData(CareerTestResult careerTestResult){
        Context context = new Context();

        Map<String, Object> data = new HashMap<>();
        data.put("careerTest", careerTestResult);

        context.setVariables(data);

        return context;
    }
}
