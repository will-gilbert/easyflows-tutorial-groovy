package org.jeasy.groovy.tutorials.work

import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReport
import org.jeasy.flows.work.DefaultWorkReport

import static org.jeasy.flows.work.WorkStatus.COMPLETED

// Java Util
import java.util.Random 

class HumanResourcesApproval implements Work {

    def employeeRequest
    def descision

    HumanResourcesApproval(def employeeRequest) {
        this.employeeRequest = employeeRequest
    }

    String getName() {
        'Human Resources Approval'
    }

    /*
    ** In this demo the descision is generated with a random boolean generator. In an
    **   actual workflow the HR manager would be prompted with work to be completed.
    */
    
    WorkReport call() {

        descision =  new Random().nextBoolean() ? 'Approved' : 'Denied'  
        println("Human Resources; $employeeRequest.employeeName have sufficent $employeeRequest.pto: $descision")

       
        new DefaultWorkReport( COMPLETED )
    }

}
