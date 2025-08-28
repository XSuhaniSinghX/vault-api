pipeline{
 agent {
  label 'windows'
        }

  stages{
   stage('Build docker image') {
    steps {
     script {
      echo 'Building Docker Image...'
       bat 'docker build -t vault-api:latest ./vault'
     }
    }
   }
 }}
