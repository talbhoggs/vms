node {
   stage('Git Checkout') { // for display purposes
    	git 'https://github.com/talbhoggs/vms'
   }
   
   stage('Compile Package') {
   		sh 'mvn package'
   }
}