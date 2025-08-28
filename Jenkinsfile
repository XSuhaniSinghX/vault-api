pipeline{
 agent {
  label 'windows'
        }

  stages{
   stage('Build docker image') {
    steps {
     script {
      echo 'Building Docker Image...'
       sh 'docker build -t vault-api:latest .'
     }
    }
   }
 }}
