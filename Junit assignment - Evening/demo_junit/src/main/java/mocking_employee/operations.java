package mocking_employee;

import java.util.ArrayList;
import java.util.List;

public class operations {
private employemanagement empm;

public operations(employemanagement empm) {
	super();
	this.empm = empm;
}
List<employee> getFilteredSalary(String user)
{
	List<employee>emp=new ArrayList<employee>();
	 List<employee> temp  = empm.retrieveEmployee();
	 
	for (int i=0;i<temp.size();i++)
	{
		if(temp.get(i).Salary>1000)
		{
			emp.add(temp.get(i));
		}
	}
	return emp;
	
}
String highestSalary(String user)
{
	List<employee> temp  = empm.retrieveEmployee();
	int maxSalary=0;
	String name = null;
	
	for (int i=0;i<temp.size();i++)
	{
		if(temp.get(i).Salary>maxSalary)
		{
			maxSalary=temp.get(i).Salary;
			name=temp.get(i).name;
		}
	}
	return name;
}
	
}

