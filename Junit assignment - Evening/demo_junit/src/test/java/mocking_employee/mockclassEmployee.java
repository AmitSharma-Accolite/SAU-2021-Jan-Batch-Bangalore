package mocking_employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;  
import org.junit.jupiter.api.Test;

class mockclassEmployee {

	@Test
	void test() {
		employee e1=new employee("Amit",5000,"banglore");
		employee e2=new employee("somya",1000,"pune");
		List<employee>emp=new ArrayList<employee>();
		emp.add(e1);
		emp.add(e2);
		employemanagement mockService=mock(employemanagement.class);
		when(mockService.retrieveEmployee()).thenReturn(emp); 

		
		
		operations op=new operations(mockService);
		List<employee> filtered=op.getFilteredSalary("dummy");

		assertEquals(1,filtered.size());

		
	}
	



}
