pipeline{
 agent {
  label 'windows'
        }

  
   stage('Build docker image') {
    steps {
     script {
       sh 'docker build -t vault-api:latest .'
     }
    }
   }
 }
