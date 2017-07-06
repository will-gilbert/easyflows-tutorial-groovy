package org.jeasy.groovy.tutorials.usage

import org.jeasy.groovy.tutorials.work.EmployeeRequest
import org.jeasy.groovy.tutorials.work.ManagerApproval
import org.jeasy.groovy.tutorials.work.HumanResourcesApproval

import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReportPredicate

import static org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow
import static org.jeasy.flows.workflow.RepeatFlow.Builder.aNewRepeatFlow
import static org.jeasy.flows.workflow.ConditionalFlow.Builder.aNewConditionalFlow
import static org.jeasy.flows.workflow.ParallelFlow.Builder.aNewParallelFlow
import static org.jeasy.flows.engine.WorkFlowEngineBuilder.aNewWorkFlowEngine

class TwoPartyApproval {

    static void main(String... args) {

        def label = 'Two Party Approval Flow'.replaceAll(/./){it+' '}
        def width = 80

        println """${'='*width}
                  |${label.center width }
                  |${'='*width}""".stripMargin()


        println '''
        |                               /----> [Manager Descision]---\\
        | [Start] --> [Employee Request]                              +---> [Final Descision]
        |                               \\----> [HR Department] ------/
        '''.stripMargin()

        def employeeRequest = new EmployeeRequest()
        def managerApproval = new ManagerApproval(employeeRequest)
        def hrApproval = new HumanResourcesApproval(employeeRequest)

        def workflow = aNewSequentialFlow()
                .named('Employee Time Off Request')
                .execute(employeeRequest)
                .then(aNewParallelFlow()
                    .named("Manager & HR approvals in parallel")
                    .execute(managerApproval, hrApproval)
                    .build())
                .build()

        workflow.call()

        // Display results; Extract values for clarity
        def name = employeeRequest.employeeName
        def pto = employeeRequest.pto
        def manager = managerApproval.descision
        def hr = hrApproval.descision

        // Parallel join logic: Both must approve
        def finalDescision = (manager == 'Approved') && (hr == 'Approved') ? 'Approved' : 'Denied'

        println "The request from $name for $pto had been $finalDescision"


    }
}
