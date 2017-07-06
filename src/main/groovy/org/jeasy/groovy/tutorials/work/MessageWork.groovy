package org.jeasy.groovy.tutorials.work


import org.jeasy.flows.work.Work
import org.jeasy.flows.work.WorkReport
import org.jeasy.flows.work.DefaultWorkReport

import static org.jeasy.flows.work.WorkStatus.COMPLETED


class MessageWork implements Work {

    def message

    MessageWork(def message) {
        this.message = message
    }

    String getName() {
        'HelloWorld'
    }

    WorkReport call() { 
        println message
        new DefaultWorkReport( COMPLETED )
    }

}
