node {
   stage('Git Checkout') { // for display purposes
    	git 'https://github.com/talbhoggs/vms'
   }
   
   stage('Compile Package') {
   		sh './opt/apache-maven-3.6.3/bin/mvn package'
   }
}