package com.project.genc.aem.training.core.core.models;
 
import org.osgi.service.component.annotations.Component;
 
@Component(service = AddressService.class)
public class AddressServiceImpl implements AddressService {
	public String country(String address) {
		int a = address.lastIndexOf(",");
		String ans="";
		for(int i=a+1;i<address.length();i++) {
			ans+=address.charAt(i);
	}
		return  ans;
		}
	}