package com.project.genc.aem.training.core.core.models;
 
 
import java.text.SimpleDateFormat;
 
import java.util.Date;
 
import org.apache.sling.api.resource.Resource;
 
import org.apache.sling.models.annotations.Default;
 
import org.apache.sling.models.annotations.Model;
 
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
 
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
 
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
 
public class CtsUserModel {
 
    @ValueMapValue
 
    @Default(values = "John Doe")
 
    private String name;
 
    @ValueMapValue
 
    private String email;
 
    @ValueMapValue
 
    private Date dob;
 
    public String getName() {
 
        return name;
 
    }
 
    public String getEmail() {
 
        return email != null ? email : generateDefaultEmail();
 
    }
 
    public String getDob() {
 
        if (dob != null) {
 
            return new SimpleDateFormat("yyyy-MM-dd").format(dob);
 
        }
 
        return "";
 
    }
 
    public String getUserId() {
 
        if (name == null || dob == null) return "default123";
 
        String initials = name.replaceAll("\\s+", "").substring(0, 3).toLowerCase();
 
        String year = new SimpleDateFormat("yyyy").format(dob);
 
        return initials + year;
 
    }
 
    private String generateDefaultEmail() {
 
        return "user@example.com";
 
    }
 
}
