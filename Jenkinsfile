node {
   stage('Git Checkout') { // for display purposes
    	git 'https://github.com/talbhoggs/vms'
   }
   
   stage('Compile Package') {
   		def mvnHome = tool name: 'maven3', type: 'maven'
   		sh '${mvnHome}/bin/mvn package -DskipTests'
   }
}