pipeline {
  environment {
    dockerimagename = "aplicacion"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Build image') {
      steps{
          sh 'chmod +x build.sh'
          sh './build.sh'
      }
    }
    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhub'
           }
      steps{
        script {
          docker.withRegistry( 'https://hub.docker.com/repositories/edergm', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }
    stage('Deploying React.js container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deployment.yaml", "service.yaml")
        }
      }
    }
  }
}
