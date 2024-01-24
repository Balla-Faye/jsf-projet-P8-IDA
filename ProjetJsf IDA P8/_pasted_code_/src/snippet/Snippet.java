package snippet;

public class Snippet {
	<!DOCTYPE html>
	<html xmlns="http://www.w3.org/1999/xhtml"
	      xmlns:h="http://xmlns.jcp.org/jsf/html"
	      xmlns:f="http://xmlns.jcp.org/jsf/core">
	
	<h:head>
	    <title>Student List</title>
	</h:head>
	
	<h:body>
	    <h2>Student List</h2>
	
	    <h:dataTable value="#{studentManagedBean.allStudents}" var="student">
	        <h:column>
	            #{student.id}
	        </h:column>
	        <h:column>
	            #{student.name}
	        </h:column>
	        <h:column>
	            #{student.email}
	        </h:column>
	    </h:dataTable>
	</h:body>
	
	</html>
	
}

