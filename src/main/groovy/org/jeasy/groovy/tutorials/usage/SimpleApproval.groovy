package org.jeasy.groovy.tutorials.usage

import org.jeasy.groovy.tutorials.work.EmployeeRequest
import org.jeasy.groovy.tutorials.work.ManagerApproval

import org.jeasy.flows.work.Work
import org.jeasy.flows.workflow.SequentialFlow.Builder as builder

import java.util.Scanner

class SimpleApproval {

    static void main(String... args) {

        def label = 'Simple Approval Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        def employeeRequest = new EmployeeRequest()
        def managerApproval = new ManagerApproval(employeeRequest)

        println '''
          | [Start] --> [Employee Request] --> [Manager Descision] --> [Final Descision]
        '''.stripMargin()

        // The 'then' and 'execute' methods are the equivalent
        def wf = builder.aNewSequentialFlow()
            .named('Employee Time Off Request')
            .execute( employeeRequest )
            .then( managerApproval )
            .build()
    
        println wf.name
        wf.call()

        // Display results; Extract values for clarity
        def name = employeeRequest.employeeName
        def pto = employeeRequest.pto
        def descision = managerApproval.descision

        println "The request from $name for $pto had been $descision"
    }
}
