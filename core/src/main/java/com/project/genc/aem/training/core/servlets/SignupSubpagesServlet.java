package com.project.genc.aem.training.core.servlets;
 
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
 
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;
 
@Component(
    service = Servlet.class,
    property = {
         Constants.SERVICE_DESCRIPTION + "=Print Subpage Titles",
         "sling.servlet.methods=GET",
         "sling.servlet.paths=/bin/signup-subpages"
    }
)
public class SignupSubpagesServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
              throws ServletException, IOException {
         response.setContentType("text/plain");
         ResourceResolver resolver = request.getResourceResolver();
         PageManager pageManager = resolver.adaptTo(PageManager.class);
 
         // Update the page path according to the given URL structure
         Page parentPage = pageManager.getPage("/content/genc-aem-training/us/en/sign-up");
         
         if (parentPage != null) {
              Iterator<Page> children = parentPage.listChildren();
              while (children.hasNext()) {
                    Page child = children.next();
                    String title = child.getTitle();
                    response.getWriter().println(title != null ? title : "Untitled Page");
              }
         } else {
              response.getWriter().println("Parent page not found.");
         }
    }
}