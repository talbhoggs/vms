node {
   stage('Git Checkout') { // for display purposes
    	git url : 'https://github.com/talbhoggs/vms', branch : env.BRANCH.trim()
   }
   
   stage('Compile Package') {
   		def mvnHome = tool name: 'maven3', type: 'maven'
		sh "${mvnHome}/bin/mvn package -DskipTests"
   }
}