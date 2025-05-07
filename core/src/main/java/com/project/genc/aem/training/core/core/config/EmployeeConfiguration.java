package com.project.genc.aem.training.core.core.config;
 
 
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.AttributeDefinition;
@ObjectClassDefinition(name = "Employee Config")
public @interface EmployeeConfiguration {
   @AttributeDefinition(name = "Employee Name")
   String employeeName() default "John";
   @AttributeDefinition(name = "Employee Address")
   String employeeAddress() default "Kolkata, WB, India";
}
 
