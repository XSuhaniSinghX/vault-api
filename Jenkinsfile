pipeline{
 agent {
  label 'windows'
        }

  stages{
   stage('Build docker image') {
    steps {
     script {
      bat 'cd vault'
      echo 'Building Docker Image...'
       bat 'docker build -t vault-api:latest .'
     }
    }
   }
 }}
