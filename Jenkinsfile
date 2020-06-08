node {
   stage('Git Checkout') { // for display purposes
<<<<<<< Updated upstream
    	git 'https://github.com/talbhoggs/vms', env.BRANCH.trim()
=======
   		def gitBranch = env.BRANCH.trim()
   		git branch: gitBranch, url: 'git@github.com:talbhoggs/vms.git'
>>>>>>> Stashed changes
   }
   
   stage('Compile Package') {
   		def mvnHome = tool name: 'maven3', type: 'maven'
		sh "${mvnHome}/bin/mvn package -DskipTests"
   }
}