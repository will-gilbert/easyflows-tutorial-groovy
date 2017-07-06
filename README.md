# EasyFlows Tutorials using Groovy

EasyFlows tutorials using Groovy beans with a Gradle build script.


## Based on [Easy Flows](https://github.com/j-easy/easy-flows/wiki) 

### Usage:

NB: Use '--quiet' or '-q' to supress Gradle build output lines

    ./gradlew usage
       Prints the following usage to the console

	./gradlew Sequential -q
	   Demo of sequential workflow
	
	./gradlew RepeatTimes -q
	   Demo of workflow state which repeats
	
	./gradlew RepeatUntil -q
	  Demo of a workflow state which repeats until a condition is met
	
	./gradlew Parallel -q
	  Demo of a workflow with a split into two workflow states and then joins
	
	./gradlew Composite -q
	  Demo a nested set of workflows
	
	./gradlew SimpleApproval -q
	  Simple employee request and manger approval
	
	./gradlew TwoPartyApproval -q
	   Employee request with both manager and human resources required approvals
              
    ./gradlew clean
     Remove all reports and artifacts from './build'

Windows Users - use ```gradlew``` instead of ```./gradlew``` to run each tutorial.
