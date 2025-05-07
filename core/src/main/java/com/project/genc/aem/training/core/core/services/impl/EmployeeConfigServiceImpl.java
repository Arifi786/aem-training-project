package com.project.genc.aem.training.core.core.services.impl;
 
import com.project.genc.aem.training.core.core.services.EmployeeConfigService;
import com.project.genc.aem.training.core.core.config.EmployeeConfiguration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
 
@Component(service = EmployeeConfigService.class, immediate = true)
@Designate(ocd = EmployeeConfiguration.class)
public class EmployeeConfigServiceImpl implements EmployeeConfigService {
   
    private String name;
    private String address;
 
    /**
     * Activates or modifies the configuration settings.
     * @param config Employee configuration object
     */
    @Activate
    @Modified
    protected void activate(EmployeeConfiguration config) {
        this.name = config.employeeName();
        this.address = config.employeeAddress();
    }
 
    /**
     * Retrieves the employee name.
     * @return the name or "Unknown" if not configured
     */
    @Override
    public String getName() {
        return name != null ? name : "Unknown";
    }
 
    /**
     * Retrieves the employee address.
     * @return the address or "Unknown" if not configured
     */
    @Override
    public String getAddress() {
        return address != null ? address : "Unknown";
    }
 
    /**
     * Extracts the country from the address.
     * @return the country name or "Unknown" if parsing fails
     */
    @Override
    public String getCountry() {
        if (address != null && address.contains(",")) {
            String[] parts = address.split(",");
            return parts[parts.length - 1].trim();
        }
        return "Unknown";
    }
}
 
