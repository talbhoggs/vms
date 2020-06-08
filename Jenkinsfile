node {
   stage('Git Checkout') { // for display purposes
		def gitBranch = env.BRANCH.trim()
		git branch: gitBranch, url: 'git@github.com:talbhoggs/vms.git'
   }
   
   stage('Compile Package') {
   		def mvnHome = tool name: 'maven3', type: 'maven'
		sh "${mvnHome}/bin/mvn package -DskipTests"
   }
}