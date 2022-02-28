package com.avin.networks.at.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.avin.networks.at.utility.ExcelUtils;


public class MethodInterceptor implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> list = ExcelUtils.getTestDetails("RUNNERMODE");
		List<IMethodInstance> result = new ArrayList<>();
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Testcasename"))) {
					if(list.get(j).get("is_executable").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("Description"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
			}
		}
		return result;
	}
}
