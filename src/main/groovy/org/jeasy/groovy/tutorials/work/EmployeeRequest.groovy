package org.jeasy.groovy.tutorials.work


import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReport
import org.jeasy.flows.work.DefaultWorkReport

// Java Util
import java.util.Scanner

// Static methods and constants
import static org.jeasy.flows.work.WorkStatus.COMPLETED


class EmployeeRequest implements Work {

    def employeeName
    def pto

    EmployeeRequest() {
    }

    String getName() {
        'Employee Request'
    }

    WorkReport call() { 

        def scanner = new Scanner(System.in)


        print('Employee Name: ')
        employeeName = scanner.nextLine()

        // Arbitary string for demo
        print('   PTO Amount: ')
        pto = scanner.nextLine()
        
        new DefaultWorkReport( COMPLETED )
    }

}
