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
   stage('Push Docker Image') {
    steps {
        echo 'Pushing Docker Image to Docker Hub...'
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', 
                                          usernameVariable: 'USERNAME', 
                                          passwordVariable: 'PASSWORD')]) {
            bat "docker login -u %USERNAME% -p %PASSWORD%"
        }
        bat "docker tag vault-api:latest xbeelzebub666x/vault-api:latest"
        bat "docker push xbeelzebub666x/vault-api:latest"
    }
}

 }}
