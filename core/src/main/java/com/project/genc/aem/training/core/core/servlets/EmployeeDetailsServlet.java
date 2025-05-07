package com.project.genc.aem.training.core.core.servlets;
 
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
 
import com.google.gson.JsonObject;
 
@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.resourceTypes=genc-aem-training/components/EmployeeDetails",
        "sling.servlet.methods=GET",
        "sling.servlet.extensions=json"
    }
)
public class EmployeeDetailsServlet extends SlingSafeMethodsServlet {
 
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("application/json");
        Resource resource = request.getResource();
       
        if (resource != null) {
            String employeeName = resource.getValueMap().get("employeeName", String.class);
            String employeeId = resource.getValueMap().get("employeeId", String.class);
 
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("employeeName", employeeName);
            jsonResponse.addProperty("employeeId", employeeId);
 
            response.getWriter().write(jsonResponse.toString());
        } else {
            response.getWriter().write("{\"error\": \"Resource not found!\"}");
        }
    }
}
 
 