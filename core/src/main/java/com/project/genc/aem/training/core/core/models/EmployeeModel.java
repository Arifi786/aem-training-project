//package com.project.genc.aem.training.core.core.models;
//
//import javax.inject.Inject;
// 
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Default;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.OSGiService;
//@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class EmployeeModel {
// 
//	@Inject
//	@Default(values = "jon ")
//    private String name;
// 
//	@Inject
//	@Default(values = "kolkata, WB, India")
//    private String address;
// 
//    @OSGiService
//    private AddressService obj;
// 
//    public String getName() {
//        return name;
//    }
// 
//    public String getAddress() {
//        return address;
//    }
// 
//    public String getCountry() {
//        return obj.country(address);
//    }
//}
// 
package com.project.genc.aem.training.core.core.models;
 
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import com.project.genc.aem.training.core.core.services.EmployeeConfigService;
 
@Model(adaptables = org.apache.sling.api.resource.Resource.class)
public class EmployeeModel {
   
    @OSGiService
    private EmployeeConfigService service;
 
    public String getName() {
        return service.getName();
    }
 
    public String getAddress() {
        return service.getAddress();
    }
 
    public String getCountry() {
        return service.getCountry();
    }
}
 
